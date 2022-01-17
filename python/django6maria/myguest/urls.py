from django.urls import path
from myguest import views

urlpatterns = [
    path('', views.listFunc),
    path('insert',views.insertFunc), 
    path('insertok',views.insertFuncOk), 
]
 