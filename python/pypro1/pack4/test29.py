# 추상 클래스
# 추상 메소드를 가진 클래스로 스스로는ㄴ 객체 생성이 불가하다.
# 추상 메소드는 자식클래스가 추상 메소드를 오버라이딩해서 일반 메소드로 만들기를 강요.

from abc import *

class AbsClass(metaclass=ABCMeta):
    @abstractmethod
    def kbsMethod(self):    #추상 메소드가 됨
        pass
    
    def normalMethod(self):
        print('추상 클래스 내에 있는 일반 메소드를 자식 클래스는 재정의 선택적')

#parent = AbsClass() TypeError: Can't instantiate abstract class AbsClass with abstract method kbsMethod

class Child1(AbsClass):     #추상 클래스를 상속 받았으므로 추상 메소드를 재정의 해야 함(강요 당함)
    name='난 child1'
    
    def mbc(self):
        print('mbc')
    
    def kbsMethod(self):
        print('추상 메소드를 재정의(오버라이드) 함')

c1=Child1()
print(c1.name)
c1.mbc()
c1.kbsMethod()
c1.normalMethod()

print()
class Child2(AbsClass):
    def kbsMethod(self):    #메소드 정의 강요당함
        print('추상 메소드를 이해하면 하루가 즐거워요')
        print('파이썬을 정복하자')
        
    def normalMethod(self): #메소드 정의를 선택적으로적음
        print('일반 메소드는 재정의가 필요할 때만 하면 된다')

c2=Child2()
c2.kbsMethod()
c2.normalMethod()

































