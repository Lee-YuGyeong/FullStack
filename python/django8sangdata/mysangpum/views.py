from django.shortcuts import render, redirect
import MySQLdb
from mysangpum.models import Sangdata
from django.core.paginator import Paginator, PageNotAnInteger, EmptyPage

config={
    'host':'127.0.0.1',
    'user':'root',
    'password':'123',
    'database':'test',
    'port':3306,
    'charset':'utf8',
    'use_unicode':True
}

# Create your views here.
def mainFunc(request):
    return render(request,'main.html')

def listFunc(request):
    #SQL문 직접 사용
    """
    sql = "select * from sangdata"
    conn = MySQLdb.connect(**config)
    cursor = conn.cursor()
    cursor.execute(sql) 
    datas = cursor.fetchall()
    print(datas)
    print(type(datas))
    """
    
    #ORM 사용 - paging 처리가 없는 경우
    #datas = Sangdata.objects.all()
    #return render(request,'list.html',{'sangpums':datas})

    #ORM 사용 - paging 처리가 있는 경우--------------------------
    datas = Sangdata.objects.all().order_by('-code')
    paginator = Paginator(datas,5) # 페이지 당 5행 씩 출력
    
    try:
        page = request.GET.get('page')
    except:
        page = 1
    
    try:
        data = paginator.page(page)
    except PageNotAnInteger:        # 페이지가 정수가 아닌 경우
        data = paginator.page(1)
    except EmptyPage:               # 페이지가 받아지지 않는 경우
        data = paginator.page(paginator.num_pages())
    
    # 개별 페이지 표시용
    allpage = range(paginator.num_pages + 1)
    print('allpage :', allpage)
    
    return render(request,'listpage.html',{'sangpums':data,'allpage':allpage})

def insertFunc(request):
    return render(request,'insert.html')

def insertokFunc(request):
    if request.method == 'POST':
        # 새로운 상품정보가 유효한지 확인
        try:
            Sangdata.objects.get(code=request.POST.get("code"))
            return render(request, 'insert.html',{'msg':'이미 등록된 코드번호입니다.'})
        except Exception as e:
            Sangdata(
                code = request.POST.get("code"), # 컬럼명, 변수명
                sang = request.POST.get("sang"),
                su = request.POST.get("su"),
                dan = request.POST.get("dan")
            ).save();
            return redirect('/sangpum/list')
    
def updateFunc(request):
    data = Sangdata.objects.get(code=request.GET.get('code'))
    return render(request, 'update.html',{'sang_one':data})

def updateokFunc(request):
    if request.method == "POST":
        upRec = Sangdata.objects.get(code=request.POST.get('code'))
        upRec.code = request.POST.get("code")
        upRec.sang = request.POST.get("sang")
        upRec.su = request.POST.get("su")
        upRec.dan = request.POST.get("dan")
        upRec.save()
        
    return redirect('/sangpum/list') # 수정 후 상품보기

def deleteFunc(request):
    delRec = Sangdata.objects.get(code=request.GET.get('code'))
    delRec.delete()
    return redirect('/sangpum/list') # 삭제 후 상품 보기


    