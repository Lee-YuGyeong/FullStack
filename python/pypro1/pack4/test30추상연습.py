# 추상 클래스 연습

from abc import *

class Friend(metaclass=ABCMeta):
    def __init__(self,name):
        self.name=name
    
    @abstractmethod
    def hobby(self):
        pass
    
    def printName(self):
        print('이름은 '+self.name)

class John(Friend):
    def __init__(self,name,addr):
        Friend.__init__(self, name)
        self.addr=addr
    
    def hobby(self):
        print(self.addr+' 동네를 뛰어다님')
    
class Chris(Friend):
    def __init__(self,name):
        Friend.__init__(self, name)
    
    def hobby(self):
        print('크리스 만세')
        print('크리스 넌 내 친구야~~~')

john=John('존','테헤란로')
john.printName()
john.hobby()

print()
ch=Chris('크리스')
ch.printName()
ch.hobby()











