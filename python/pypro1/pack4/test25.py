# 클래스의 상속 관계
class Person:
    say='난 사람이야~'   #파이썬의 클래스 멤버는 public이 기본
    nai='20'
    __kbs=''    #__변수='값'    private member
    
    def __init__(self, nai):
        print('Person 생성자')
        self.nai=nai
    
    def printInfo(self):
        print('나이 : {}, 이야기 : {}'.format(self.nai, self.say))
        
    def hello(self):
        print('안녕')
        print('kbs : ',self.__kbs)
        
    @staticmethod
    def mbc(tel):
        print('mbc 전화 :',tel)

p=Person('22')
p.printInfo()   #Bound method call
p.hello()
#print('kbs : ',p.__kbs)    에러 : private이라서
Person.printInfo(p) #Unbound method call

print('-----------------')
class Employee(Person):
    say="일하는 동물"
    subject='근로자'
    def __init__(self):
        print('Employee 생성자')
    
    def printInfo(self):
        print('Employee 클래스의 printInfo')
    
    def eprintInfo(self):
        print(self.say, super().say)
        self.hello()
        self.printInfo()

e=Employee()
print(e.say, e.nai, e.subject)
e.eprintInfo()
e.printInfo()

print('^^^' * 20)
class Worker(Person):
    def __init__(self, nai):
        print('Worker 생성자')
        super().__init__(nai)   #부모의 생성자를 호출. Bound method call
        
    def wprintInfo(self):
        print(self.say, super().say)
        self.printInfo()
        super().printInfo()

w=Worker('30')
w.wprintInfo()

print('%%%'*20)
class Programmer(Worker):
    def __init__(self,nai):
        print('Programmer 생성자')
        super().__init__(nai)   #부모의 생성자를 호출. Bound method call
        Worker.__init__(self, nai)  ##부모의 생성자를 호출. Unbound method call
    
    def wprintInfo(self):
        print('메소드 오버라이드')

pr=Programmer('33')
print(pr.say,pr.nai)
pr.printInfo()
pr.wprintInfo()

print('\n------클래스 타입-------------------------------')
a=5
print(type(a))
print(type(w))
print(type(pr))
print()
print(Programmer.__bases__)
print(Worker.__bases__)
print(Person.__bases__)

print()
p.mbc('111-1111')
Person.mbc('222-2222')
e.mbc('333-3333')
pr.mbc('444-4444')
w.mbc('555-5555')












