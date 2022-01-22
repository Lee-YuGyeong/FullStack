from django.urls import path

from employee import views

urlpatterns = [
    path('buser', views.buserFunc),
    path('gogek', views.gogekFunc),
    path('jikwon', views.jikwonFunc),
]