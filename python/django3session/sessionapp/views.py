from django.shortcuts import render
from django.http.response import HttpResponseRedirect
from gevent.libev.corecext import NONE

# session : 일정 시간 동안 사용자의 정보를 웹 서버 컴에 담아두고 연결이 지속되는 효과를 보기위한 방법

# Create your views here.
def mainFunc(request):
    return render(request,'main.html') # forward 방식
    
def setOsFunc(request):
    print("request.GET : ",request.GET)
    if "favorite_os" in request.GET:
        print(request.GET['favorite_os'])
        # request.session['세션키'] # 해당 클라이언트의 세션에 값을 주거나 읽기 
        request.session['f_os'] = request.GET['favorite_os'] # "f_os"라는 키로 session을 생성
        return HttpResponseRedirect("/showos") # redirect 방식(클라이언트를 통해 요청 처리)
    else:
        return render(request,'selectos.html') # forward 방식
    
def showOsFunc(request):
    #print("showOsFunc 도착")
    dict_context = {}
    if 'f_os' in request.session:
        print('유효시간 : ', request.session.get_expiry_age())
        dict_context['sel_os'] = request.session['f_os']
        dict_context['message'] = "그대가 선택한 운영체제는 %s"%(request.session['f_os'])
    else:
        dict_context['sel_os'] = None
        dict_context['message'] = '운영체제를 선택하지 않았어요'
        
    # del request.session["f_os"]     # 참고 : 세션 삭제 
    request.session.set_expiry(5)   # 5초 동안 세션이 유효, 기본값은 30분
    return render(request,'show.html',dict_context)
        