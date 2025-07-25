# 🧠 MythSnare — Misinformation Detection with Real-Time Voice Intelligence

**MythSnare** is an intelligent, voice-enabled platform that detects misinformation using live transcription, AI-powered fact-checking, and real-time interaction. It distinguishes between factual statements and regional news, offering users a chatbot-style experience to verify claims from various media inputs — including speech, text, and files.

---

## ✨ Features

- 🎙️ **Voice Assistant**: Speak directly to MythSnare — it transcribes and responds in real time.
- 🔊 **Live Transcription**: Converts live speech to text instantly via WebSockets and Whisper/SpeechRecognition.
- 📂 **Multimedia Support**: Upload audio/video/text for automatic transcription and fact-checking.
- 🧠 **Misinformation Detection**:
  - Factual statements: Verified using an LLM (e.g., GPT).
  - Regional news: Cross-referenced with RSS feeds and real-time scraping.
- 🌍 **Multilingual Input**: Accepts and transcribes speech in multiple languages.
- 💬 **Chatbot Interface**: Intuitive UI for seamless conversation with AI.
  
---

## 🛠️ Tech Stack

### 🔧 Backend
- **Django** (core framework)
- **Django Channels** (WebSockets for real-time transcription)
- **Whisper / Whisper.cpp** (audio transcription)
- **SpeechRecognition** (Google API for lightweight live transcription)
- **Custom NLP Models** (for text classification)

### 💻 Frontend
- **Chatbot UI** with file upload and live transcription streaming

### 🔍 Fact Checking
- **OpenAI GPT / LLM APIs**
- **RSS Feed Parsing + Scraping** (for regional news verification)

---

## 🚀 Installation & Setup

### 1. Clone the Repo

```bash
git clone https://github.com/Sanjay-nithin/Mythsnare.git
cd Mythsnare
```

### 2. Create a Virtual Environment (Optional)
```bash
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
```

### 3. Install Dependencies
```bash
pip install -r requirements.txt
```

### 4. API Key Setup

To use MythSnare's fact-checking capabilities via OpenRouter (LLM API), you'll need to create an API key:

#### 1. Sign Up & Create API Key
- Visit [Open Router](https://openrouter.ai/keys)
- Sign in with your account (GitHub, Google, etc.)
- Click "Create Key" and copy the generated API key (e.g., `sk-xxxxxxxxxxxxxxxxxxxxx`)

#### 2. Paste the key 

In 'templates/' directory there is a .env file paste the key
```bash
OPEN_ROUTER_API_KEY=YOUR OPEN ROUTER KEY
```



### 5. Run the app
```bash
daphne truthtell.asgi:application
```

## 📂 Project Structure
```bash
Mythsnare/
│
├── media/                   # Sample data to upload
├── results/checkpoint-500/  # Results of the classification model
├── trained_model/           # Custom trained classification model
├── transcribe/              # Contains the app's logic
│   │
│   └──templates/            # Frontend html,css, javascript files
├── truthtell                # Django's main project 
└── requirements.txt         # Dependencies
  
```

## Future Enhancements
- Voice feedback
- Support for fake image/video detection
- Deep fake audio warnings


