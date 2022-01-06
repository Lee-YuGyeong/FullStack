#사용자 정의 함수 : 개발자가 직접 함수를 작성
#def 함수명(인수...): ...        형식

print('뭔가를 하다가...')

def func1():
    print('func1 처리')
    
def Func2(arg): #파이썬에서는 함수의 이름의 시작을 소문자, 대문자 상관없다
    print('안녕'+arg)
    
#함수 선언 후 호출
func1()
print('다른거 하다가')
func1() #()는함수를 실행해라
func1   #함수이름을 써준거, 실행안함
print(func1)    #()을 안써주고 함수의 이름만 쓰면 함수 주소가 나온다. 함수의 이름은 함수 객체에 대한 주소를 기억
kbs=func1   #kbs에 함수의 주소를 치환함, kbs도 func1과 같은 주소를 갖고있다.
kbs()
print()
Func2('방가방가')   #()안에 arg를 안주면 에러가 난다, Func2(arg)의 함수에는 '안녕'+arg 이므로 arg에는 문자형이 된다.

print()
def func3(a1, a2):  #아규먼트가 2개!
    hap=a1+a2
    return hap      #리턴값이 있다.

result=func3(3, 4)
print(result)       #결과값: 7
print(func3(3, 4))  #결과값: 7

def func4():
    print('func4')  #함수는 "return 반환값" 이 없는 경우 None을 반환/파이썬에서 함수는 값이 없더라도 반환을 한다.
    
imsi=func4()
print(imsi)         #결과값: None
print(func4())      #결과값: None

print()
def func5(aa):
    if aa % 2 ==1:
        return      #반환값 없이 그냥 빠져나옴
    else:
        bb=["짝수", "여러값 반환", "복수 값은 묶음형으로 반환"]   #여러값을 반환하고 싶으면 묶음형으로 반환하면 된다.
        return bb
    
print(func5(10))    #결과값: ['짝수', '여러값 반환', '복수 값은 묶음형으로 반환']
print(func5(11))    #결과값: None

print()
def area_tri(a, b): #a밑변 b높이
    c=a*b/2
    area_print(c)   #함수는 다른 함수를 호출 가능
    
def area_print(c):
    print("삼각형의 면적은 ",c)
    
area_tri(20, 30)

print()
def func6():
    print('func6 처리')
    def func7():        #함수 안에 함수 선언 가능-inner function
        print('func7 처리')
    func7()             #func7을 실행해라, a()가 a함수를 실행하라는 뜻임, 함수는 수행이 끝나면 자기를 부른 곳으로 돌아가도록 만들어져있다.

func6() #결과값: func6 처리 \n func7 처리

print()
def swapfunc(a,b):
    return b,a      #return (b,a)와 같은 뜻이다. 반환값은 무조건 하나로만 반환해야한다. 묶음형 자료 하나를 반환한 것이지 두개를 반환한 것이 아니다!!

a=10; b=20
print(swapfunc(a, b))   #결과값: (20, 10)






