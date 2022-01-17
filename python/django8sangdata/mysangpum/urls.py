from django.urls import path
from mysangpum import views

urlpatterns = [
    path('list',views.listFunc), 
    path('insert',views.insertFunc), 
    path('insertok',views.insertokFunc),
    path('update',views.updateFunc),
    path('updateok',views.updateokFunc),
    path('delete',views.deleteFunc),
    
]