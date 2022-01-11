from django.shortcuts import render
from django.http.response import HttpResponse

# Create your views here.
def indexFunc(request):
    msg = "장고 만세"
    ss = "<html><body>우리는 새로운 세상을 만나고 있다. %s</body></html>"%(msg,)
    return HttpResponse(ss)