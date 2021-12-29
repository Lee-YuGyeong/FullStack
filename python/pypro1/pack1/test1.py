'''
여러 줄
주석
'''
"""
여러 줄
주석. 파이썬은 ' 와 "를 구분하지않는다.
"""

#한 줄 주석

# 변수 이해
var1 = '안녕 파이썬'
print(var1)
var1 = 123; print(var1)
var1 = '변수의 type은 입력자료에 의해 결정'
print(var1)

A = 10 # 변수명은 대소문자를 구분
a = 20
print(A,' ',a)

a = 10
b = 12.3
c = b # 객체의 주소를 치환
print(a,b,c)
print('주소확인 함수 사용 : ', id(a), id(b), id(c))
print(a is b,a == b) # False False    is 는 객체 주소 비교, ==은 객체 값 비교
print(b is c,b == c) # True True

a = [1,2]
b = a
c = [1,2]
print(a is b, a==b) # True True
print(a is c, a==c) # False True

print()
import keyword  # 키워드 목록을 읽기 위한 외부 모듈 로딩
print('파이썬 키워드(예약어) 목록 : ', keyword.kwlist) #['False', 'None', 'True', '__peg_parser__', 'and', 'as', ...
#변수명으로 키워드를 쓰지 않는다. 특수문자로 변수명이 시작되면 안된다.
# and = 10 에러

print('type 함수로 자료형 확인')
print(3, type(3))
print(3.4, type(3.4))
print(3+4j, type(3+4j))
print(True, type(True))
print('문자열', type('문자열'))
print()
print((1,), type((1,))) # <class 'tuple'>
print([1],type([1])) # <class 'list'>
print({1},type({1})) # <class 'set'>
print({'key':1},type({'key':1})) # <class 'dict'>
