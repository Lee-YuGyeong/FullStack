from django.shortcuts import render
from myapp.models import Article

# Create your views here.
def mainFunc(request):
    return render(request, 'main.html')

def showDbFunc(request):
    
    datas = Article.objects.all() # Django ORM. select * from article
    print(datas) # <QuerySet [<Article: Article object (1)>,...
    print(datas[0].name) # 참치김밥
    return render(request,'articlelist.html',{'articles':datas})

def showDbFunc2(request):
    
    datas = Article.objects.all() # Django ORM. select * from article
    return render(request,'articlelist2.html',{'articles':datas})