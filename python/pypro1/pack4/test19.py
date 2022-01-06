# class
from astropy.io.misc.yaml import name
class Car:
    handle=0    #멤버 변수
    speed=0     
    
    def __init__(self, name, speed):
        self.name=name
        self.speed=speed
    
    def showData(self): #메소드
        km='킬로미터'       #지역변수
        msg='속도:'+str(self.speed)+km
        return msg
    
print("원형 클래스 멤버(prototype 값 중 하나 출력 : ", Car.handle)
#print(Car.showData())   #Car type의 객체가 아직 생성된 적이 없으므로 에러
print()
car1=Car('tom', 10)     #생성자를 호출하며 Car type의 객체 생성
print('car1 객체 : ',car1.handle, car1.name, car1.speed)
car1.color='파랑'
print(car1.color)

print()
car2=Car('james',20)  #생성자 오버로딩이 없고 다 똑같다..?
print('car2 객체 : ',car2.handle, car2.name, car2.speed)  #객체에 handle값이 없어서 원형타입으로 가서 handle값을 가져온다.(=prototype)
#print(car2.color)   #AttributeError: 'Car' object has no attribute 'color' // color는 car1만 가지고 있기때문에 에러

print('객체 주소 : ',Car, car1, car2)
print('객체 주소 : ',id(Car), id(car1), id(car2))   #주소가 다 다르다, 객체가 3개가 만들어진 것임, 모두 고유공간을 가지고 있다. 고유공간내의 멤버는 self로 참조한다.
print(car1.__dict__)    #객체의 맴버를 확인하는 키워드 // 결과값: {'name': 'tom', 'speed': 10, 'color': '파랑'}
print(car2.__dict__)    #결과값 : {'name': 'james', 'speed': 20} // dict형(키:값)

print('\n메소드 호출--------')
print('car1 메소드 : ', car1.showData())
print('car2 메소드 : ', car2.showData())
car1.speed=110
car2.speed=120
print('car1 메소드 : ', car1.showData())
print('car2 메소드 : ', car2.showData())
Car.handle=1

print(car1.handle)  #지역변수가 없어서 원형 클래스에서 갖고 있는 handle인 1을 찾아옴
print(car2.handle)


