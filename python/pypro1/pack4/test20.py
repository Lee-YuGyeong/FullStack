#class의 이해
kor=100     #모듈의 멤버 : 전역변수

def abc():
    print('모듈의 멤버 중 함수')
    
class My:   #모듈의 멤버 중 클래스
    kor=77
    #생성자의 내용이 없는 경우에는 생성자를 적지 않아도 된다.
    
    def abc(self):
        print('클래스의 멤버 중 메소드')
    
    def show(self): #클래스의 멤버 중 메소드(어떠한 행위를 함 -> process 수행)
        kor=88
        print('kor : ',kor) #메소드의 지역변수를 찾고 없으면 모듈의 멤버를 호출, 결과값 : 88
        print('kor : ',self.kor)    #결과값 : 77
        self.abc()  #클래스의 멤버인 메소드를 호출
        abc()       #모듈의 멤버인 함수를 호출
        
m=My()  #생성자를 호출하면 객체를 생성
m.show()    #결과값 : 88

print('--------------')
class Our:
    a=1
    
print(Our.a)

our1=Our()
print(our1.a)

our2=Our()
print(our2.a)

print()
our2.a=77   #our2 만 77을 기억
our2.b=10   #our2 만 b 변수에 10을 기억
print(Our.a)
print(our1.a)
print(our2.a)
