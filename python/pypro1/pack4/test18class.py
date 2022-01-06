'''
클래스 : 새로운 이름 공간을 지원하는 단위이다. 메소드와 멤버변수(필드)로 구성된다.
자원의 재활용을 목적으로 클래스의 포함, 상속을 지원
모듈의 멤버
접근지정자 X, 메서드 오버로딩 X
'''
print('파이썬의 클래스는 모듈의 멤버 중 하나임')
def func1():        #함수(function)에는 self를 쓰면 안된다. self는 예약어(키워드)이다.
    print('요것은 함수')
    
class TestClass:    #선언과 동시에 객체가 생성이 됨. 이름공간(메모리)을 확보,prototype
    aa=1    #클래스의 멤버 변수(멤버 필드)
    
    #콜백함수이다. 부르는게 아닌 자동으로 불러짐
    def __init__(self): #메소드, 객체가 생성되면서 한번만 자동으로 실행됨
        print('생성자')
        
    def __del__(self):  #메소드, 객체가 사라지면서 실행됨
        print('소멸자')
        
    def printMessage(self): #메소드(Method), self가 없으면 메소드가 아니다. 메소드에는 self를 적어줘야한다.
        name="홍길동"    #지역변수 : 해당 메소드에서만 유효
        print(name)
        print(self.aa)  #클래스의 멤버변수를 불러오려면! (약간 자바의 this같은 느낌인데 똑같진 않다)

print(TestClass, id(TestClass)) #클래스타입, 클래스 객체주소
print(TestClass.aa) #클래스 자체가 객체로 만들어졌기 때문에 클래스.변수명 해서 값을 받아올 수 있다.
#TestClass.printMessage()    #객체변수의 이름이 아닌 클래스의 이름으로 멤버변수를 부름    TypeError: printMessage() missing 1 required positional argument: 'self'
print()
#test=TestClass      #주소 치환
test=TestClass()    #생성자를 통해 해당 클래스 타입의 객체 생성
print(test.aa)
test.printMessage() #메소드 호출 시에 객체변수가 자동으로 인자로 적용.  Bound method call 방식
#객체변수의 이름으로 멤버변수를 불렀다.. 이렇게 써주면 자동으로 객체변수가 ()안으로 들어간다.


print()
TestClass.printMessage(test)    #메소드 호출 시에 객체변수가 수동으로 인자로 적용  UnBound method call 방식
#다 실행되고 test가 없어지면 소멸자가 나옴

print(type(1))
print(type(1.2))
print(type(test))   #이세상에 없는 클래스를 직접 만든것임!(자바처럼)
#객체가 두 개 생성됨
print(id(TestClass))    #아래와 주소가 다름
print(id(test))         #위와 주소가 다름
