from django.shortcuts import render

# Create your views here.
from employee.models import Buser, Jikwon, Gogek
from django.db.models.aggregates import Count


def mainFunc(request):
    return render(request, 'main.html')


def buserFunc(request):
    data = Buser.objects.all()
    # print(data)
    return render(request, 'buser.html', {'data': data})


def jikwonFunc(request):
    if request.GET.get('buser_no'):
        # print(request.GET.get('buser_no'))
        data = Jikwon.objects.filter(buser_num=request.GET.get('buser_no'))


        '''
        # prefetch 로 outer join 해주고
        outerJoin = Jikwon.objects.prefetch_related('gogek_set')
        #print(list(outerJoin)[1].gogek_set.all())
        #print(outerJoin.values())

        # 부서번호로 filter
        filtered =outerJoin.filter(buser_num=request.GET.get('buser_no'))
        a =filtered.values('jikwon_no').annotate(Count('gogek_damsano'))
        print(a)
        '''
        '''
        #print(type(list(filtered)[0]))
        #print(list(filtered)[0])
        #for i in list(filtered):
        #    print(i.gogek_set.all())
            
        # filter 된 값을 gogek
        '''


        '''
        onePerson = Jikwon.objects.get(jikwon_no=2)
        print(onePerson.jikwon_name)
        clients = onePerson.gogek_set.all()
        print(clients.values())

        return render(request, 'jikwon.html', {'data': data})
        '''
        #print(data.prefetch_related('gogek_set'))

        gogekNumQuery = data.prefetch_related('gogek_set').values('jikwon_no').annotate(Count('gogek')).values()

        print(gogekNumQuery)


        dictList = []

        for i in data.values():
            gogekNum = Gogek.objects.filter(gogek_damsano=i['jikwon_no']).count()
            # print(gogekNum)
            i['gogekNum'] = gogekNum
            dictList.append(i)
        # print(dictList)
        #return render(request, 'jikwon.html', {'data': dictList,'gogekCnt':gogekNumQuery})
        return render(request, 'jikwon.html', {'data': gogekNumQuery})


def gogekFunc(request):
    if request.GET.get('jikwon_no'):
        data = Gogek.objects.filter(gogek_damsano=request.GET.get('jikwon_no')).order_by('-gogek_damsano')
        print(data)
        return render(request, 'gogek.html', {'data': data})
