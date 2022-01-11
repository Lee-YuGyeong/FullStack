#상속 : 자원의 재활용을 목적으로 부모와 자식 간의 관계를 형성. 다형성을 구사.

class Animal:
    #...
    nai = 0
    
    def __init__(self):
        print('Animal 생성자')
    
    def move(self):
        print('움직이는 생물')
    
class Dog(Animal): # java : entends Animal
    
    def __init__(self):
        print('Dog 생성자')
    
    def dogmy(self):
        print('나는 댕댕이라고 해요')

dog1 = Dog()
dog1.move()
dog1.dogmy()

print()
class Horse(Animal):
    pass

horse = Horse()

