from django.shortcuts import render

# Create your views here.
def mainFunc(request):
    return render(request,'main.html')

def showFunc(request):
    if request.method=='POST':
        gender = request.POST["gender"]
        pic='/static/images/{}.png'.format(gender)
        return render(request,'show.html',{'gender':gender,'pic':pic})
    