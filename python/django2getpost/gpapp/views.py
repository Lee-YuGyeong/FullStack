from django.shortcuts import render
from django.views.generic.base import TemplateView

# Create your views here.
def mainFunc(request):
    return render(request, 'index.html')

class CallViewClass(TemplateView):
    template_name = 'callget.html'
    
    
def insertFunc(request): # get/post를 구분
    if request.method == 'GET':
        print('get 방식일 때 처리')
        return render(request, 'insert.html')
    elif request.method == 'POST':
        print('post 방식일 때 처리')
        # 클라이언트에서너 넘긴 자료 받기
        # message = request.POST.get("msg")
        message = request.POST["msg"] # 위와 동일
        return render(request, 'list.html',{'message':message})
    else:
        print('요청 에러')