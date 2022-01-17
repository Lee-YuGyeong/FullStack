from django.contrib import admin
from myapp.models import Article

# Register your models here.
# 관리자 창에서 테이블 정오블 보기위함
class ArticleAdmin(admin.ModelAdmin):
    list_display = ('id','code','name','price','pub_date')
    
admin.site.register(Article,ArticleAdmin)