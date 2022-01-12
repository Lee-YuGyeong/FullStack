from django.shortcuts import render


# Create your views here.
def mainFunc(request):
    return render(request, 'main.html')


def page1Func(request):
    return render(request, 'page1.html')


def page2Func(request):
    return render(request, 'page2.html')


def cartFunc(request):
    pass


def buyFunc(request):
    pass
