#일급함수의 성립 조건
#함수 안에 함수를 선언 가능, 인자로 함수를 전달, 반환값으로 함수를 사용 가능
#파이썬은 일급함수, 일급객체를 지원하는 언어이다.

def func1(a,b):
    return a+b  #함수사용

func2=func1     #주소 치환, ()을 쓰지 않고 함수의 이름만 적어주면 함수의 주소를 나타낸다. 
print(func1(3,4))   #결과값: 7
print(func2(3,4))   #결과값: 7, 결과가 위와 같음!

print()
def myfunc(fu):     #fu 변수는 함수를 전달 받음 /fu는 마음대로 이름 지은거임 변경가능
    def ourfunc():  #함수 안에 함수 선언 가능
        print('나는 내부함수야~~')
        
    ourfunc()
    return fu       #함수를 반환

kbs=myfunc(func1)   #fu 변수에 func1함수를 전달, ()을 안썼기 때문에 func1의 주소를 전달한 것임/ 결과값: 나는 내부함수야~~ /리턴값(kbs의 값):func1의 주소를 받음. 
print('kbs :',kbs)  #func1의 주소가 찍힘 / 결과값: kbs : <function func1 at 0x000002403CD10280>
print('func1 :',func1)  #func1의 주소를 출력해봄, 위와 결과가 동일함
print(kbs(3,4))     #결과값: 7

print('\n--람다(Lambda) 함수 : 이름이 없는 한 줄 짜리 함수----------')
#형식 - lambda 인자... : 표현식  //인자는 없으면 생략가능함

def hap(x, y):
    return x+y

print(hap(3, 4))    #결과값: 7

#위 코드를 람다로 써보기 (람다는 복잡하지 않은 함수를 한줄로 쓰거나, 함수를 써야하는데 함수를 쓰기 불편할때 사용한다.)
print((lambda x, y:x+y)(3,4))   #결과값: 7 // return을 생략하고 바로 결과를 적어주면 된다. / (lambda 인자x,인자y:표현식x+y)(값3,값4)

aa=lambda x, y:x*y+10   #람다는 담아줘도 된다.
print(aa)   #람다의 주소를 불러옴 // 결과값: <function <lambda> at 0x0000022F9F90CC10>
print(aa(3,4))  #결과값: 22 //3*4+10=22

bb=lambda : print('람다 처리')  #인자 줄게 없으면 안적어주고 표현식만 적어도 된다.
bb()    #결과값: 람다 처리

print()
kbs=lambda a, su=10:a+su    #람다도 변수에 초기값을 줄 수 있다.
print(kbs(5))   #결과값: 15
print(kbs(5,6)) #결과값: 11

kbs=lambda a, *tu, **di:(a,tu,di)    #람다도 가변 인수를 지정할 수 있다.
print(kbs(1,2,3))   #결과값: (1, (2, 3), {})
print(kbs(1,2,3,m=4, n=5))  #결과값:(1, (2, 3), {'m': 4, 'n': 5})

print()
li=[lambda a,b:a+b,lambda a,b:a*b]
print(li[0](3,4))   #결과값: 7    /li의 0번째 함수 사용
print(li[1](3,4))   #결과값: 12    /li의 1번째 함수 사용

print('다른 함수의 속성 값으로 람다를 사용')
# 내장함수 filter(함수, 묶음형자료)
print(list(filter(lambda a:a<5,range(10)))) #0~9사이의 숫자(=0이상 10미만) 중 5 미만인 값만 출력 //결과값: [0, 1, 2, 3, 4] /range(...)는 묶음형 자료이다.
print(list(filter(lambda a:a<5,[0,1,2,3,4,5,6,7,8,9])))    #결과값: [0, 1, 2, 3, 4]
print(list(filter(lambda a:a%2,range(10)))) #결과값: [1, 3, 5, 7, 9] //파이썬에서는 0이면 false, 1이면 true이다. //0:false, none, [], {}, () 등등등.. 전에 다뤘었다.//조건이 참인 것만 나온다. 그러므로 0인 짝수는 안나오고 1인 홀수만 나옴
print(list(filter(lambda a:a%5==0 or a%7==0,range(1,101)))) #5의 배수이거나 7의 배수만 나온다.

print('-----------')
# @함수 장식자(function decorator):meta(어떠한 정보를 가짐) 기능이 있다.
def make2(fn):  #아규먼트로 함수를 받음
    return lambda : "안녕" + fn()

def make1(fn):
    return lambda : "방가워~~" +fn()

def hello():
    return "홍길동"

hi=make2(make1(hello))  #hi는 make2(make1(hello))의 주소를 받아옴  
print(hi())     #결과값: 안녕방가워~~홍길동

print()

@make2  #함수 장식자로 밑에 있는 make1함수를 감싸줌(=인자로 받음)
@make1  #밑에 있는 hello2함수를 감싸줌
def hello2():
    return "고길동"

print(hello2()) #결과값: 안녕방가워~~고길동

print('---재귀함수 : 함수가 자기자신을 호출 - 반복처리가 가능--------')
#반복처리 : for, while, 재귀함수(recursive function)

def countdown(n):
    if n==0:
        print('완료')
        #return  #생략가능
    else:
        print(n, end=' ')
        countdown(n-1)  #자기가 자기를 부른다.
        
countdown(5)    #결과값: 5 4 3 2 1 완료

#1~10까지의 정수의 합 : for, while, 재귀함수 모두 가능함
def totfunc(n):
    if n==1:
        print('탈출')
        return True
    return n+totfunc(n-1)   #재귀함수 - 자기가 자기를 부름

result=totfunc(10)
print('10 까지의 합은',result)   #결과값: 10 까지의 합은 55
