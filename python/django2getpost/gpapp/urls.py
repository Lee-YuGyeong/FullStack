# 메인 url에 의해 위임된 요청을 처리하는 모듈
# 각 app(어플리케이션) 마다 생성해서 사용하면 된다.

from django.urls import path
from gpapp import views

urlpatterns = [
    path('insert',views.insertFunc), 
    
]