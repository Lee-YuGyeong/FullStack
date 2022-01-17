from django.contrib import admin
from myfriend.models import Friend

# Register your models here.

class FriendAdmin(admin.ModelAdmin):
    list_display = ('id','name','address','age')
    
admin.site.register(Friend,FriendAdmin)