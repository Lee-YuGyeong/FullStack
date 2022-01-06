# 변수의 생존 범위 : 프로그램 실행 도중 변수를 공유하는 영역

player='전국대표'   #전역변수(global variable), 모듈(현재파일)의 어디서든 호출 가능

def funcSoccer():
    name='한국인'  #지역변수(local variable), 현재 함수 안에서만 유효
    player="동네대표"   #지역변수가 호출 우선순위가 높다.
    print(name, player)
   
funcSoccer()    #결과값: 한국인 전국대표
#print(name)     #NameError: name 'name' is not defined
print(player)   #결과값: 전국대표, 3번째 줄과 같은 줄이니까(들여쓰기 안했으니까) 같은 레벨이다

#파이썬은 파일 하나가 모듈임, 여러개의 모듈(=파일)이 모이면 라이브러리, 여러개의 라이브러리가 모이면 프레임워크
print('-------------')
a=10; b=20; c=30    #전역변수
#print('1) a:',a, ',b:',b,',c:',c)    #결과값: 1) a:10, b:20, c:30
print('1) a:{}, b:{}, c:{}'.format(a,b,c))  #결과값: 1) a:10, b:20, c:30 위와 동일

def foo():
    a=40    #foo 함수의 지역변수 - foo가 실행하는 동안만 생존한다.
    b=50
    def bar():
        #c=60        #bar 함수의 지역변수 - bar가 실행하는 동안만 생존한다.
        global c    #c는 전역변수를 의미한다.
        print('2) a:{}, b:{}, c:{}'.format(a,b,c))
        #c=60    #UnboundLocalError: local variable 'c' referenced before assignment  // global c가 없었을때 c는 지역변수이고 c가 치환하기전에 값이 없어서 생긴 에러!!, 그러므로 print 위에 적어줘야한다. global c를 써서 전역변수가 됬으면 써도 에러 안남.
    bar()

foo()
print('foo 수행 후 최종) a:{}, b:{}, c:{}'.format(a,b,c))    #전역변수를 찾는것임, 같은 레벨의 



