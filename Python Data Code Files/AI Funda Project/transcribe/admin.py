from django.contrib import admin
from .models import Register

@admin.register(Register)
class RegisterAdmin(admin.ModelAdmin):
    list_display = ('username', 'created_at', 'password')
    search_fields = ('username', 'password', )
    ordering = ('-created_at',)
