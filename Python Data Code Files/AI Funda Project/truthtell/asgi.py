import os
from channels.routing import ProtocolTypeRouter, URLRouter
from django.core.asgi import get_asgi_application
import transcribe.routing  # Use your actual app name here

os.environ.setdefault("DJANGO_SETTINGS_MODULE", "truthtell.settings")

application = ProtocolTypeRouter({
    "http": get_asgi_application(),
    "websocket": URLRouter(transcribe.routing.websocket_urlpatterns),
})
