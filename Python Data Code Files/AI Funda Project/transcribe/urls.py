from django.urls import path
from . import views

# Create your tests here.
urlpatterns = [
    path('',views.login_view, name="login"),
    path('register/',views.register_view , name="register"),
    path('home/', views.home, name="home"),   
    path('about/',views.about,name="about"),
    path('contact/',views.contact,name="contact"),
    path('detect/',views.transcription_view,name="detect"),
    path('classify-text/', views.classify_text, name="classify_text")
]
