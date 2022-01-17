from django.shortcuts import render
from sangpumapp.models import Maker, Product
from django.db.models.aggregates import Sum, Avg, Count, Max, Min,StdDev, Variance

# Create your views here.
def main(request):
    return render(request,'main.html')

def list1(request):
    makers = Maker.objects.all()
    return render(request,'list1.html',{'makers':makers})

def list2(request):
    products = Product.objects.all()
    pcount = len(products) # 파이썬 명령어
    
    # ORM QuerySet 참조
    print(products) # <QuerySet [<Product: Product object (1)>,...
    print(products.values_list()) # <QuerySet [(1, '치즈버거', 7000, 1),
    for row in products.values_list():
        print(row) # (1, '치즈버거', 7000, 1)...
    
    print(Product.objects.all().count()) # 장고 명령어
    print(products.aggregate(Sum('price'))) # {'price__sum': 82000}
    print(products.aggregate(Avg('price'))) # {'price__avg': 16400.0}
    print(products.aggregate(StdDev('price'))) #{'price__stddev': 14444.3761}
    print(products.aggregate(Count('price'))) # {'price__count': 5}
    print(products.aggregate(Max('price'))) # {'price__max': 45000}
    print()
    print(products.filter(pname__contains='버거'))
    print(products.filter(pname='치킨버거').aggregate(Avg('price')))
    print(products.exclude(pname='치킨버거'))
    
    # 그룹별(pname) 해당 칼럼의 평균
    imsi = products.values('pname').annotate(Sum('price'))
    print(imsi)
    for r in imsi:
        print(r) # 
    
    return render(request,'list2.html',{'products':products,'pcount':pcount})

def list3(request):
    mid = request.GET.get('id')
    products = Product.objects.filter(maker_name=mid)
    pcount = products.count()
    return render(request,'list2.html',{'products':products,'pcount':pcount})