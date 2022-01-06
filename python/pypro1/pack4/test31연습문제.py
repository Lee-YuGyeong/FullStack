
from abc import *

class Employee(metaclass=ABCMeta):
    
    def __init__(self,irum,nai):
        self.irum=irum
        self.nai=nai
    
    @abstractmethod
    def pay(self):
        pass
    
    @abstractmethod
    def data_print(self):
        pass
    
    def irumnai_print(self):
        print('이름은 : '+self.irum+', 나이는 : '+str(self.nai),end=", ")


class Temporary(Employee):
    
    def __init__(self,irum,nai,ilsu,ildang):
        Employee.__init__(self, irum, nai)
        self.ilsu=ilsu
        self.ildang=ildang
    
    def pay(self):
        return self.ilsu*self.ildang
        
    
    def data_print(self):
        self.irumnai_print()
        print('월급 : '+str(self.pay()))


class Regular(Employee):
    
    def __init__(self, irum, nai, salary):
        Employee.__init__(self, irum, nai)
        self.salary=salary
    
    def pay(self):
        return self.salary
    
    def data_print(self):
        self.irumnai_print()
        print('급여 : '+str(self.pay()))


class Salesman(Regular):
    
    def __init__(self, irum, nai, salary, sales, commission):
        Regular.__init__(self, irum, nai, salary)
        self.sales=sales
        self.commission=commission
    
    def pay(self):
        return super().pay()+(self.sales*self.commission)
    
    def data_print(self):
        self.irumnai_print()
        print('수령액 : '+str(self.pay()))


t=Temporary('홍길동',25,20,15000)
t.data_print()

r=Regular('한국인',27,3500000)
r.data_print()

s=Salesman('손오공',29,1200000,5000000,0.25)
s.data_print()










