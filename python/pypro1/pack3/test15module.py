#module(라이브러리) : 소스코드의 재사용을 목적으로 하며, 소스코드를 하나의 이름공간으로 구분하고 관리함.
#표준 모듈, 사용자 정의 모듈, 제3자 모듈(Third party)로 구분

#내장된 표준 모듈
print('뭔가를 하다가...')

import sys
print('모듈 경로: ', sys.path)
#sys.exit()      #응용프로그램의 강제 종료

import math
print(math.pi)
print()
print(math.sin(math.radians(30)))   #30디그리를 얻는것임, 외부모듈 씀

import calendar
calendar.setfirstweekday(6) #6:일요일(0123456-월화수목금토일) 6이 첫번째 날짜가 되게 하는 함수
calendar.prmonth(2022, 1)   #2022년 1월달 달력이 나온다
del calendar
a=10
#del a   #a값 삭제하기 delete
print(a)

print('난수 관련 모듈')
import random           
print(random.random())  #랜덤값이 나옴, 모듈명(random).모듈의 멤버(random()) 해서(= random.random()) 사용함
print(random.randrange(1, 10, 1))   #1부터 10까지의 랜덤값, 마지막 숫자가 3이면 4, 7이 나옴(1+3, 1+3+3)

from random import random   #from 모듈명 import 모듈의 멤버(클래스, 전역변수, 함수), 자주쓰이면 이런식으로 쓸 수도 있다. 
print(random())

from random import random, randrange
print(randrange(1,10,1))

#from random import *    #이 방법은 추천하지 않는다. 메모리 소모가 많이 생긴다
#print(random())



print('프로그램 종료')

