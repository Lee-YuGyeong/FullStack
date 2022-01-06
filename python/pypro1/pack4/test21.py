#클래스는 새로운 타입을 만들 수 있다.
#예를 들어 가수가 갖춰야 할 기본 속성이나 행위를 클래스로 선언하고 객체 생성

class Singer:
    title_song='아 대한민국~~'
    
    #생성자는 생략
    
    def sing(self):
        msg='노래는 '
        print(msg, self.title_song, '랄랄라~~')
        
    # ...
    
bts=Singer()
bts.sing()
print()

blackpink=Singer()
blackpink.sing()

blackpink.title_song='댄싱퀸'
blackpink.sing()
blackpink.co='YG'
print('blackpink 소속사 : ',blackpink.co)

print()
bts.sing()
#print('bts 소속사 : ',bts.co)  #co가 없어서 오류/AttributeError: 'Singer' object has no attribute 'co'

print()
print('주소 : ', id(bts), id(blackpink))  #주소는 다르다.
print(type(bts), type(blackpink))       #타입은 같다
 