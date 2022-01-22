from django.contrib import admin

# Register your models here.
from employee.models import Buser, Gogek, Jikwon


class BuserAdmin(admin.ModelAdmin):
    list_display = ('buser_no','buser_name','buser_loc','buser_tel')

admin.site.register(Buser, BuserAdmin)


class GogekAdmin(admin.ModelAdmin):
    list_display = ('gogek_no','gogek_name','gogek_tel','gogek_jumin','gogek_damsano')

admin.site.register(Gogek, GogekAdmin)

class JikwonAdmin(admin.ModelAdmin):
    list_display = ('jikwon_no','jikwon_name','buser_num','jikwon_jik','jikwon_pay','jikwon_gen','jikwon_rating')

admin.site.register(Jikwon,JikwonAdmin)