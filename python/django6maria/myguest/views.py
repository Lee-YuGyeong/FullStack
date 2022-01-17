from django.shortcuts import render, redirect
from myguest.models import Guest
from django.utils import timezone
from datetime import datetime
from django.http.response import HttpResponseRedirect

# Create your views here.

def mainFunc(request):
    return render(request, 'main.html')

def listFunc(request):
    print(Guest.objects.get(id=1))
    print(Guest.objects.filter(id=1))
    print(Guest.objects.filter(title='문안'))
    print(Guest.objects.filter(title__contains='문안'))
    
    gdata=Guest.objects.all()
    # 정렬    select * from 테이블명 order by 칼럼명 asc(desc)
    #gdata=Guest.objects.all().order_by('title')     # ascending
    #gdata=Guest.objects.all().order_by('-title')    # descending
    #gdata=Guest.objects.all().order_by('-id')
    #gdata=Guest.objects.all().order_by('title', '-id')  # title ascending, id descending
    
    return render(request, 'list.html', {'gdatas':gdata})

def insertFunc(request):
    return render(request, 'insert.html')

def insertFuncOk(request):
    if request.method=='POST':
        #print(request.POST.get('title'))
        #print(request.POST['title'])
        #print(request.POST['content'])
        
        #sql : insert into guest(title,content,regdate) values(...)
        Guest(
            title=request.POST['title'],
            content=request.POST['content'],
            #regdate=datetime.now()
            regdate=timezone.now()
        ).save()
    
    #return redirect('/guest')   # 추가 후 자료 보기
    return HttpResponseRedirect('/guest') # 위와 결과 동일

"""
참고:
수정은 
g = Guest.objects.get(id=아이디값)
g.title = title=request.POST['title']
g.context = request.POST['content']
g.save()

삭제는
g = Guest.objects.get(id=아이디값)
g.delete()


"""








