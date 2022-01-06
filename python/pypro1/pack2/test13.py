#함수 인수(argument(=arg))와 매개변수(parameter)

def showGugu(start, end=5): #start, end=5는 argument임. 인수에다가 변수의 초기치를 줄 수도 있다. 함수를 부를때 end에 값을 안넣어주면 end는 5가 되고, 함수를 부를때 end에 3을 넣어주면 end는 3이된다. 
    for dan in range(start, end+1): #(2이상 4미만 이라서 dan은 2,3임)
        print(str(dan)+'단 출력')

showGugu(2, 3)  #2,3은 매개변수임/ 순서로 매핑 / 결과값: 2단 출력 \n3단 출력
print()
showGugu(2) #end 값을 안적어줘서 end값은 5가된다. for문에서 2이상 6미만이라서 dan이 2,3,4,5가 됨 // 결과값: 2단 출력 \n3단 출력 \n4단 출력 \n5단출력
print()
showGugu(start=2, end=3)    #이름으로 매핑
print()
showGugu(end=3, start=2)    #이름으로 매핑
print()
showGugu(2, end=3)
print()
#showGugu(start=3, 2)  #에러!! 두번째 값이 상수가 들어오면 무조건 에러이다.

print('가변 인수 : 입력 값이 동적인 경우')
#연산자중에 test2에 packing연산이라는게 있다. 그것을 써주면 된다..

def func1(*ar): #매개변수에 *(packing 연산자를 사용)을 사용하여 tuple type으로 값을 받음
    print(ar)
    
func1(1)        #결과값: (1,) / tuple로 나온다.
func1(1, 2)     #결과값: (1, 2)
func1(1, 2, 3)  #결과값: (1, 2, 3)

print()
def func2(a, *ar):
#def func2(*ar, a):   #에러!! packing 연산자는 뒤에 위치해야함
    print(a)
    print(ar)
    
func2(10)       #결과값: 10 \n()
func2(10, 20, 30)   #결과값: 10 \n(20, 30)
func2('kbs', 'mbc', 'sbs')  #결과값: kbs \n('mbc', 'sbs')

print()
def func3(w, h, **etc): #**(별 두개)는 dict type(사전형/ {key:value})으로 처리
     print('몸무게:',w)
     print('키:',h)
     print('기타:',etc)

func3(60, 170, irum='홍길동', nai=22)  #결과값: 몸무게: 60 \n키: 170 \n기타: {'irum': '홍길동', 'nai': 22}

print()
def func4(a,b,*c,**d):
    print(a, b)     #결과값: 1 2
    print(c)        #결과값: (3, 4, 5)
    print(d)        #결과값: {'m': 6, 'n': 7}
    
func4(1,2,3,4,5,m=6,n=7)    #결과값: 1 2 \n(3, 4, 5) \n{'m': 6, 'n': 7}



