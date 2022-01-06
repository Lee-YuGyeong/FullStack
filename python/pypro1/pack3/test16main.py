#사용자 정의 모듈 작성 후 로딩

print('뭔가를 하다가 .....')

list1=[1,3]
list2=[1,2]

import pack3.mymod1 #import 패키지명.모듈명
#파이썬은 접근지정자가 없다. 기본적으로는 모두 public이다.
print('tot는 ',pack3.mymod1.tot)
pack3.mymod1.listHap(list1, list2)

print()
print(dir())    #dir()하면 현재 모듈의 멤버를 볼 수 있음    __로 시작하는건 기본적으로 파이썬이 제공하고 있는 모듈에서 사용하는 키워드이다.


if __name__=='__main__':    #응용 프로그램의 시작점
    print('여기야~ 현재 파일이 응용프로그램의 시작 지점이야!!')  #프로그램짤때는 명시적으로 알리는게 좋다, 인터프리터는 응용프로그램의 메인이 어딘지 알고있음
    
#다른 모듈(py파일)의 멤버 부르기 계속--- 방법은 취향이지 정해져있지 않다.
print()
from pack3 import mymod1
mymod1.kbs()

from pack3.mymod1 import mbc, kbs, tot
mbc()
kbs()
print(tot)

import pack3.mymod1 as nice #nice라고 별명을 붙여줌
nice.kbs()

print('----패키지가 다른 곳에 저장된 모듈 읽기---------')
import other.mymod2
print(other.mymod2.Hap(5, 3))

from other.mymod2 import Cha
print(Cha(5, 3))

print('python path가 걸려 있는 폴더에 모듈 읽기')
import mymod3
print(mymod3.Gop(5, 3))

from mymod3 import Nanugi
print(Nanugi(5,3))

print('그래픽 지원 모듈 사용----')
from turtle import *
p=Pen()
p.color('red', 'yellow')
p.begin_fill()
while True:
    p.forward(200)
    p.left(170)
    if abs(p.pos()) < 1:
        break
p.end_fill()
done()  #창 강제닫기안함

import pygame



