'''
다중 상속 : 순서가 중요함!
'''
class Tiger:
    data='호랑이 세상'
    
    def cry(self):
        print('호랑이 울부짖음')
        
    def eat(self):
        print('맹수는 고기를 좋아함')

class Lion:
    msg='밀림은 동물의 왕국'
    
    def cry(self):
        print('사자는 외친다. 으르렁')
    
    def hobby(self):
        print('백수의 왕은 낮잠이 취미~')

class Liger1(Tiger, Lion):
    pass

lione=Liger1()
lione.cry()
lione.eat()
lione.hobby()

print('--------------')
class Liger2(Lion, Tiger):
    data='라이거 만세'
    
    def play(self):
        print('라이거는 매우 행복합니다')
    
    def hobby(self):
        print('라이거는 새로운 취미, 프로그램 개발이 즐겁답니다')

litwo=Liger2()
print(litwo.data)
litwo.cry()
litwo.eat()
litwo.hobby()


































