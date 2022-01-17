from django.shortcuts import render
from myfriend.models import Friend

# Create your views here.
def mainFunc(request):
    return render(request,'main.html')

def showDBFunc(request):
    
    datas = Friend.objects.all()
    print(datas)
    return render(request,'list.html',{'friends':datas})