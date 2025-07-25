import json
import whisper
import speech_recognition as sr
import io
import sys
import tempfile
import subprocess
from channels.generic.websocket import AsyncWebsocketConsumer
import os
import logging 

# Setup logger
logger = logging.getLogger(__name__)
logging.basicConfig(level=logging.DEBUG)

whisper_model = whisper.load_model("base")
recognizer = sr.Recognizer()

class TranscriptionConsumer(AsyncWebsocketConsumer):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.audio_chunks = []

    async def connect(self):
        await self.accept()

    async def disconnect(self, close_code):
        self.audio_chunks = []  # Clear audio buffer on disconnect

    async def receive(self, text_data=None, bytes_data=None):
        if text_data:
            data = json.loads(text_data)
            if data.get("type") == "text":
                user_msg = data.get("message", "")
                logger.info(f"User text: {user_msg}")
                await self.send(json.dumps({"transcription": f"Echo: {user_msg}"}))

            elif data.get("type") == "stop":
                await self.process_audio()
                self.audio_chunks = []  # Clear buffer after transcription
        elif bytes_data:
            self.audio_chunks.append(bytes_data)

    async def process_audio(self):
        if not self.audio_chunks:
            logger.warning("No audio chunks to process.")
            return

        temp_webm_path = None
        temp_wav_path = None

        try:
            all_audio = b"".join(self.audio_chunks)

            with tempfile.NamedTemporaryFile(delete=False, suffix=".webm") as webm_file:
                webm_file.write(all_audio)
                temp_webm_path = webm_file.name

            with tempfile.NamedTemporaryFile(delete=False, suffix=".wav") as wav_file:
                temp_wav_path = wav_file.name

            command = [
                "ffmpeg", "-y", "-i", temp_webm_path,
                "-ac", "1", "-ar", "16000", "-sample_fmt", "s16",
                temp_wav_path
            ]
            result = subprocess.run(command, capture_output=True)

            # If ffmpeg fails, raise error
            if result.returncode != 0 or not os.path.exists(temp_wav_path):
                logger.error("FFmpeg failed: " + result.stderr.decode())
                await self.send_transcription("Error converting audio")
                return

            # Transcribe the WAV
            with sr.AudioFile(temp_wav_path) as source:
                audio_data = recognizer.record(source)
                try:
                    transcription = recognizer.recognize_google(audio_data)
                except sr.UnknownValueError:
                    result = whisper_model.transcribe(temp_wav_path)
                    transcription = result["text"]
                except sr.RequestError:
                    transcription = "Google API unavailable"
                
                logger.info(f"Transcription: {transcription}")
                await self.send_transcription(transcription)

        except Exception as e:
            logger.error(f"Error processing audio: {e}")
            await self.send_transcription("Error transcribing audio")

        finally:
            if temp_webm_path and os.path.exists(temp_webm_path):
                os.remove(temp_webm_path)
            if temp_wav_path and os.path.exists(temp_wav_path):
                os.remove(temp_wav_path)
            self.audio_chunks = []  # Ensure it's cleared

    async def send_transcription(self, text):
        await self.send(text_data=json.dumps({
            "type": "transcription",
            "text": text
        }))
