"""django2getpost URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from gpapp import views
from gpapp.views import CallViewClass
from django.urls.conf import include
 
urlpatterns = [
    path('admin/', admin.site.urls),
    
    # 요청 URL에 대한 request 처리 방법 3가지 : Function views, Class-based views, Including another URLconf
    path('',views.mainFunc),    # Function views
    path('gpapp/callget',CallViewClass.as_view()), #Class-based views
    path('data/', include('gpapp.urls')),   # Including another URLconf (각각의 app에서 요청 처리)
]
