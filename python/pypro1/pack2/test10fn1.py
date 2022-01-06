'''
함수 : 반복 소스의 단순화, 재활용이 목적, 독립적으로 구성된 프로그램 소스 코드의 집합
'''
# 내장함수 : 파이썬 설치시 함께 설치되는 함수
# 자주 쓰이는 모듈은 import 생략, 가끔 사용되는 모듈은 import 모듈명 으로 메모리로 로딩 후 사용

print('내장함수 중 콘솔로 자료를 출력하는 함수')
a=[1,3,5,7,9]
hap=sum(a)
print(hap)
print(sum(a)+int(100))   #함수 안에 또 함수를 쓸 수도 있다! sum(a), int(100)
b=eval('1+20+10')   #문자열인데 수식이 있으면 eval 함수를 사용하면 숫자로 계산이 된다   
print(b)    #결과값 : 31

print(round(1.2), round(1.6))   #round는 반올림, 내장 함수이다.  결과값: 1 2
import math
print(math.ceil(1.2), math.ceil(1.6))   #정수 근사치(근사값) 중 큰 수, 결과값: 2 2 (무조건 올림!!)
print(math.floor(1.2), math.floor(1.6)) #정수 근사치(근사값) 중 작은 수, 결과값: 1 1 (무조건 내림!!)

c=[True,1,False]
print(all(c))   #값이 다 True(참)이여야 True, 결과값: False
print(any(c))   #값이 하나라도 True(참)이면 True, 결과값: True

x=[10, 20, 30]
y=['a','b']
for i in zip(x, y): #많이 쓰임!! 짝이 없으면 버리고, x와 y값으로 쌍을 이루어준다.
    print(i)    #결과값: (10, 'a') \n (20, 'b')



