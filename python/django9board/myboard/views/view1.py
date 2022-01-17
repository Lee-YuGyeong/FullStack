from django.shortcuts import render, redirect
from myboard.models import BoardTab
from django.http.response import HttpResponseRedirect
from datetime import datetime
from django.core.paginator import Paginator, PageNotAnInteger, EmptyPage

# Create your views here.
def mainFunc(request):
    aa = "<div><h2>메인 화면</h2></div>"
    return render(request, 'main.html',{'main':aa})

def listFunc(request):
    datas_all = BoardTab.objects.all().order_by('-id')
    
    paginator = Paginator(datas_all, 5)
    page = request.GET.get('page')
    try:
        datas = paginator.page(page)
    except PageNotAnInteger:
        datas = paginator.page(1)
    except EmptyPage:
        datas = paginator.page(paginator.num_pages)
    
    return render(request, 'board.html', {'datas' : datas})

def insertFunc(request):
    return render(request, 'insert.html')

def insertokFunc(request):
    if request.method == "POST":
        try:
            gbun = 1 # Group number 구하기
            datas = BoardTab.objects.all()
            if datas.count() !=0:
                gbun = BoardTab.objects.latest('id').id + 1
                
            BoardTab(
                name = request.POST.get('name'),
                passwd = request.POST.get('passwd'),
                mail = request.POST.get('mail'),
                title = request.POST.get('title'),
                cont = request.POST.get('cont'),
                bip = request.META['REMOTE_ADDR'], # request.META.get('REMOTE_ADDR')
                bdate = datetime.now(),
                readcnt = 0,
                gnum = gbun,
                onum = 0,
                nested = 0,
            ).save()
            
        except Exception as e:
            print('추가 에러 : ',e)
            return redirect(request, 'error.html')
    return HttpResponseRedirect("/board/list") # 추가 후 목록보기
    #return redirect("/board/list")
    

def searchFunc(request):    # 검색용
    if request.method == "POST":
        s_type = request.POST.get('s_type')
        s_value = request.POST.get('s_value')
        #print(s_type, s_value)
        
        # SQL의 like 연산과 유사한 칼럼명__contains=값을 사용
        
        if s_type == 'title':
            datas_search = BoardTab.objects.filter(title__contains=s_value).order_by('-id')
        elif s_type == 'name':
            datas_search = BoardTab.objects.filter(name__contains=s_value).order_by('-id')
    
            
        paginator = Paginator(datas_search, 5)
        page = request.GET.get('page')
        try:
            datas = paginator.page(page)
        except PageNotAnInteger:
            datas = paginator.page(1)
        except EmptyPage:
            datas = paginator.page(paginator.num_pages)
        
        return render(request, 'board.html', {'datas' : datas})


def contentFunc(request): # 내용 상세 보기
    page = request.GET.get('page')
    data = BoardTab.objects.get(id = request.GET.get('id'))
    data.readcnt = data.readcnt + 1
    data.save() # 조회수 갱신
    return render(request, 'content.html',{'data_one':data, 'page':page})
    
def updateFunc(request):
    try:
        data = BoardTab.objects.get(id=request.GET.get('id'))
    except Exception as e:
        print('수정 자료 읽기 오류 : ',e)
        return redirect(request, 'error.html')
    return render(request, 'update.html',{'data_one':data})

def updateokFunc(request): # 수정 처리
    try:
        upRec = BoardTab.objects.get(id=request.POST.get('id'))
        
        # if upRec.passwd == request.POST.get('up_passwd'): # 비밀번호 비교
        #     upRec.name = request.POST.get('name')
        #     upRec.mail = request.POST.get('mail')
        #     upRec.title = request.POST.get('title')
        #     upRec.cont = request.POST.get('cont')
        #     upRec.save()
        upRec.name = request.POST.get('name')
        upRec.mail = request.POST.get('mail')
        upRec.title = request.POST.get('title')
        upRec.cont = request.POST.get('cont')
        if upRec.passwd == request.POST.get('up_passwd'): # 비밀번호 비교
            upRec.save()
        else:
            return render(request, 'update.html',{'data_one':upRec,'msg':'비밀번호 불일치!'})
        
    except Exception as e:
        print('수정 자료 오류 : ',e)
        return redirect(request, 'error.html')
    return redirect('/board/list')

def deleteFunc(request):    # 삭제용
    try:
        delData = BoardTab.objects.get(id=request.GET.get('id'))
    except Exception as e:
        print('삭제 자료 읽기 오류 : ',e)
        return render(request, 'error.html')
    return render(request, 'delete.html',{'data_one':delData})
    

def deleteokFunc(request):
    delData = BoardTab.objects.get(id=request.POST.get('id'))
    
    if delData.passwd == request.POST.get('del_passwd'): # 비밀번호 비교
        delData.delete()
        return redirect('/board/list') # 삭제 후 목록보기
    else:
        return render(request, 'error.html') # 비밀번호가 틀린경우
    