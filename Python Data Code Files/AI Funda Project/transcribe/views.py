from django.shortcuts import render, redirect
from django.http import JsonResponse, HttpResponseBadRequest
import whisper
import speech_recognition as sr
import json
from pydub import AudioSegment
from django.views.decorators.csrf import csrf_exempt
import os
import traceback
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages
from django.conf import settings
from django.contrib.auth.decorators import login_required 
from django.core.files.storage import FileSystemStorage
from transformers import BertTokenizer, BertForSequenceClassification
from .models import Register
from .forms import ContactForm
import torch
import requests
import re
import feedparser
from sentence_transformers import SentenceTransformer
import urllib.parse
import spacy
from spacy import displacy
import wikipedia
from dotenv import load_dotenv

# Initialize Whisper model and SpeechRecognition recognizer
whisper_model = whisper.load_model("small")
recognizer = sr.Recognizer()

model = BertForSequenceClassification.from_pretrained('./trained_model')
tokenizer = BertTokenizer.from_pretrained('bert-base-uncased')

# Load spaCy model for NER (Named Entity Recognition)
nlp = spacy.load("en_core_web_sm")

load_dotenv()

def register_view(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        confirm_password = request.POST.get('confirm_password')

        if password != confirm_password:
            messages.error(request, 'Passwords do not match.')
            return render(request, 'register.html')

        if Register.objects.filter(username=username).exists():
            messages.error(request, 'Username already taken.')
            return render(request, 'register.html')

        new_user = Register(username=username, password=password)
        new_user.save()
        messages.success(request, 'Registration successful! Please log in.')
        return redirect('login')

    return render(request, 'register.html')


def login_view(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')

        try:
            user = Register.objects.get(username=username)
            if user.password == password:
                request.session['user_id'] = user.id
                request.session['user_name'] = user.username
                messages.success(request, 'Login successful!')
                return redirect('home')
            else:
                messages.error(request, 'Invalid username or password.')
        except Register.DoesNotExist:
            messages.error(request, 'User does not exist.')
    return render(request, 'login.html')

def logout_view(request):
    logout(request)
    return redirect('login')


def home(request):
    return render(request, 'home.html')

def about(request):
    return render(request, 'about.html')


def contact(request):
    if request.method == 'POST':
        # Handle contact form submission
        name = request.POST.get('name')
        email = request.POST.get('email')
        message = request.POST.get('message')
        # Implement email sending or save to database
        return render(request, 'contact.html', {'success': True})
    return render(request, 'contact.html')

def contact_view(request):
    if request.method == 'POST':
        form = ContactForm(request.POST)
        if form.is_valid():
            form.save()
            return render(request, 'contact_success.html')  # Or redirect
    else:
        form = ContactForm()
    return render(request, 'contact.html', {'form': form})

@csrf_exempt
def transcription_view(request):
    if request.method == "POST":
        print("POST request received.")
        uploaded_file = request.FILES.get("audio_file")
        user_text = request.POST.get("text_input", "").strip()

        if uploaded_file:
            print("Audio file received:", uploaded_file.name)
            file_name = uploaded_file.name
            temp_input_path = os.path.join(settings.MEDIA_ROOT, file_name)
            with open(temp_input_path, "wb") as f:
                for chunk in uploaded_file.chunks():
                    f.write(chunk)

            try:
                converted_path = convert_to_wav(temp_input_path)
            except Exception as e:
                traceback.print_exc()
                return JsonResponse({"error": f"Conversion failed: {str(e)}"}, status=500)

            try:
                lang_code = detect_language_whisper(converted_path)
                print("Language code passed:", lang_code)
            except Exception as e:
                traceback.print_exc()
                return JsonResponse({"error": f"Language detection failed: {str(e)}"}, status=500)

            try:
                transcription = transcribe_with_whisper(converted_path)
            except Exception as e:
                traceback.print_exc()
                return JsonResponse({"error": f"Transcription failed: {str(e)}"}, status=500)

            return JsonResponse({"status": "success", "transcription": transcription})

        print("No input provided.")
        return JsonResponse({"error": "No input provided"}, status=400)

    print("GET request: rendering template.")
    return render(request, "transcription.html")

def convert_to_wav(input_path, output_path="converted.wav"):
    """Converts any audio/video file to a proper PCM WAV format."""
    audio = AudioSegment.from_file(input_path)
    audio = audio.set_frame_rate(16000).set_channels(1).set_sample_width(2)  # 16-bit mono
    audio.export(output_path, format="wav")
    return output_path

def detect_language_whisper(audio_path):
    """Detects language using Whisper."""
    audio = whisper.load_audio(audio_path)
    audio = whisper.pad_or_trim(audio)
    mel = whisper.log_mel_spectrogram(audio).to(whisper_model.device)
    _, probs = whisper_model.detect_language(mel)
    lang_code = max(probs, key=probs.get)
    return lang_code  # Return the Whisper detected language code

def transcribe_with_whisper(audio_path):
    """Transcribe audio using Whisper."""
    result = whisper_model.transcribe(audio_path)
    return result["text"]

@csrf_exempt
def classify_text(request):
    if request.method == 'POST':
        try:
            data = json.loads(request.body.decode('utf-8'))
            text = data.get('message', '')

            if not text:
                return JsonResponse({'error': 'Text is required'}, status=400)

            # BERT Classification (Determine whether the text is a Fact or News)
            inputs = tokenizer(text, return_tensors="pt", padding=True, truncation=True)
            outputs = model(**inputs)
            prediction = torch.argmax(outputs.logits, dim=-1)
            label = "Fact" if prediction.item() == 0 else "News"

            # Extract entities from the input text using spaCy for better clarity
            entities = extract_entities(text)

            # Fetch Wikipedia summary based on the main query or top entity
            wikipedia_summary = get_wikipedia_summary(text)  # Fetch Wikipedia summary based on query

            # Common headers and payload for LLaMA API
            headers = {
                "Authorization": f"Bearer {os.getenv('OPEN_ROUTER_API_KEY')}",
                "Content-Type": "application/json"
            }
            print(label)
            # If Fact: Directly use LLaMA for fact verification
            if label == "Fact":
                payload = {
                    "model": "meta-llama/llama-4-maverick:free",
                    "messages": [
                        {
                            "role": "system",
                            "content": (
                                "You are a fact checker. Respond ONLY in this strict JSON format:\n"
                                "{\n"
                                "  \"is_true\": true or false,\n"
                                "  \"confidence\": number between 0 and 100 based on how accurate you are with the answer,\n"
                                "  \"explanation\": \"Your explanation here.\"\n"
                                "}\n"
                                "Do not include any additional text, emojis, or commentary outside the JSON."
                            )
                        },
                        {
                            "role": "user",
                            "content": f"Check the accuracy of the following statement: {text}\n\n"
                                       
                        }
                    ]
                }

                response = requests.post("https://openrouter.ai/api/v1/chat/completions", headers=headers, json=payload)
                if response.status_code == 200:
                    try:
                        fact_data = json.loads(response.json()['choices'][0]['message']['content'])
                        explanation = fact_data.get('explanation', 'No explanation provided.')
                        is_true = fact_data.get('is_true')
                        confidence = fact_data.get('confidence')

                        return JsonResponse({
                            'prediction': 'Fact',
                            'is_true': is_true,
                            'confidence': confidence,
                            'explanation': explanation,
                        })
                    except Exception as e:
                        return JsonResponse({
                            'prediction': 'Fact',
                            'is_true': None,
                            'confidence': None,
                            'explanation': f"Failed to parse fact check data: {str(e)}",
                        })
                else:
                    return JsonResponse({'error': 'Failed to verify fact via LLaMA model.'}, status=500)

            else:
                # NEWS CASE — Fetch articles based on named entities
                articles = []
                for entity in entities:
                    entity_text = entity['text']
                    rss_feed_url = f'https://news.google.com/rss/search?q={urllib.parse.quote(entity_text)}'
                    articles += get_relevant_articles(entity_text, rss_feed_url)

                if not articles:
                    return JsonResponse({
                        "prediction": "News",
                        "message": "No relevant news found.",
                        'entities': entities
                    })

                # Select the top 5 relevant articles (or any limit you want)
                selected_articles = articles[:10]

                # 🧠 Now send the selected articles to LLaMA for checking
                article_details = "\n".join(
                    [f"Title: {clean_html(article.get('title', 'No title'))}\nSummary: {clean_html(article.get('summary', 'No summary'))}" for article in selected_articles]
                )
                print(article_details)
                payload = {
                    "model": "meta-llama/llama-4-maverick:free",
                    "messages": [
                        {
                            "role": "system",
                            "content": (
                                "You are a highly skilled fact checker. Analyze the following information and provide your confident assessment."
                                " Respond ONLY in this strict JSON format:\n"
                                "{\n"
                                "  \"is_true\": true or false,\n"
                                "  \"confidence\": number between 0 and 100 based on how accurate you are with the answer,\n"
                                "  \"explanation\": \"Your explanation here. Be confident in your judgment. Provide the reasoning for your assessment.\"\n"
                                "}\n"
                                "Do not include any additional text, emojis, or commentary outside the JSON."
                            )
                        },
                        {
                            "role": "user",
                            "content": (
                                f"Evaluate the accuracy of the following statement:\n\n"
                                f"Statement: {text}\n\n"
                                f"Here are some articles that may help you assess it. Based on your own judgment, do you consider the statement to be true or false?\n"
                                f"Articles:\n{article_details}\n\n"
                                f"Here is some relevant Wikipedia summary that might help:\n{wikipedia_summary}"
                                "Provide your response based on the overall content and context, not just the articles themselves. "
                                "Make your own conclusion based on the information provided. "
                                "Do not mention the word article or wikipedia in your result. provide the result confidently. "
                            )
                        }
                    ]
                }


                response = requests.post("https://openrouter.ai/api/v1/chat/completions", headers=headers, json=payload)
                if response.status_code == 200:
                    try:
                        fact_data = json.loads(response.json()['choices'][0]['message']['content'])
                        explanation = fact_data.get('explanation', 'No explanation provided.')
                        is_true = fact_data.get('is_true')
                        confidence = fact_data.get('confidence')

                        return JsonResponse({
                            'prediction': 'News',
                            'is_true': is_true,
                            'confidence': confidence,
                            'explanation': explanation,
                        })
                    except Exception as e:
                        return JsonResponse({
                            'prediction': 'News',
                            'is_true': None,
                            'confidence': None,
                            'explanation': f"Failed to parse fact check data: {str(e)}",
                        })
                else:
                    return JsonResponse({'error': 'Failed to verify news via LLaMA model.'}, status=500)

        except Exception as e:
            traceback.print_exc()
            return JsonResponse({'error': str(e)}, status=500)

    return HttpResponseBadRequest("Only POST method is allowed.")


    return HttpResponseBadRequest("Only POST method is allowed.")

def get_relevant_articles(query, rss_feed_url):
    """Fetch and filter articles based on query."""
    feed = feedparser.parse(rss_feed_url)
    relevant_articles = []
    if 'entries' in feed:
        for e in feed.entries[:5]:
            relevant_articles.append(e)
    return relevant_articles


def clean_html(raw_html):
    """Remove HTML tags from summary text."""
    clean_text = re.sub('<.*?>', '', raw_html)
    return clean_text.strip()

def extract_entities(text):
    """Extract named entities from the given text using spaCy."""
    doc = nlp(text)
    entities = []
    for ent in doc.ents:
        entities.append({'text': ent.text, 'label': ent.label_})
    return entities

def get_wikipedia_summary(query):
    """Fetch a relevant Wikipedia summary based on the query."""
    try:
        # Search for the page related to the query
        page = wikipedia.page(query)
        summary = page.summary  # This is a short summary of the page
        return summary
    except wikipedia.exceptions.DisambiguationError as e:
        # If there are multiple possibilities, take the first one
        return wikipedia.page(e.options[0]).summary
    except wikipedia.exceptions.HTTPTimeoutError:
        return "Wikipedia request timed out."
    except wikipedia.exceptions.RedirectError:
        return "Redirect error occurred while fetching Wikipedia page."
    except wikipedia.exceptions.PageError:
        return "No Wikipedia page found for the query."
    except Exception as e:
        return str(e)