#int, float, bool, complex 는 객체 값 하나를 참조
# 집합 (묶음) 자료형 : 여러개의 값을 참조
from lxml.html.builder import LI
from sympy.functions.special.error_functions import Li

# 1) str type : 문자들의 집합 기억을 위한 클래스 - 순서0, 수정X
print('\n문자열(str) type - 순서 0, 수정 x --------')
s = 'sequence' 
print(s, id(s))
print('크기 : ',len(s))
print('검색 위치',s.find('e'),s.find('e',3),s.rfind('e'))
print('첫글자 유무 : ',s.startswith('s'),s.startswith('a'))
# 문자열 관련 함수는 다수가 있다. 검색해서 사용하길 권장

print('인덱싱과 슬라이싱')
print('인덱싱 :',s[0],s[-1])
print('슬라이싱 : ',s[0:3],s[-5:-1]) # ~이상 ~미만
print('슬라이싱 : ',s[3:],s[-5:], s[3:7:2],s[::2])

# s[0] = 'k' # TypeError: 'str' object does not support item assignment

#str type의 객체는 수정불가
aa = 'kbs'
print(aa,id(aa))
aa = 'sbs'
print(aa,id(aa))

print('\n리스트(list) type - 순서 0, 수정 x , 중복 0 --------')
a = [1,2,3] # 대괄호 안에 요소를 기억
b = [10,a,20.5,True,'문자열']
print(b,type(b))
b.append('요소 추가')
print(b)
b += [11,22]
b.extend(['mbc','11'])
b.insert(1, "삽입")
b.remove('mbc') # 값에 의한 삭제
print(b)
print()
print(b[0],b[1],b[2],b[2][0])
print(b[-9:-3:2])
print(b[1:5:2])
print(b[1:8:2])

del b[0] # 순서에 의한 삭제
print(b) 
del b # 변수 b를 제거
# print(b)


print('\n튜플(tuple) type - 순서 0, 수정 x , 중복 0 , 속도가 빠름 --------')
t = (1,'a','b','abc') #소괄호 안에 요소를 기억
t = 1,'a','b','abc'
print(t,type(t))
t1 = (1) # 요소값 하나일 때는 주의
print(t1,type(t1))
t2 = (1,)
print(t2,type(t2))
print(t[0],t[2],t[2:4])
#t[0] = 100 # TypeError: 'tuple' object does not support item assignment

t3 = (10,20)
print(t3)
a,b = t3
print(a,b)


print(t3,type(t3))
li = list(t3) # 형변환
print(li,type(li))
t4 =tuple(li) # 형변환
print(t4,type(t4))

print('\n세트(set) type - 순서 x, 중복 0 --------')
a = {1,2,3,4}
print(a,type(a))
# print(a[0]) # TypeError: 'set' object is not subscriptable

li = [1,2,2,3,1,4]
print(li)
s = set(li)
li = list(s)
print(li)

print("\n사전(dict) type - {'키':값}으로 구성 ,'키'의 순서 x, 중복 X --------")
mydic = dict(k1=1,k2='abc',k3=1.2)
print(mydic,type(mydic))
mydic = {'파이썬':'뱀','자바':'커피','스프링':123}
print(mydic)
mydic['오라클'] = '예언자' # 추가
del mydic['자바'] # 요소 삭제
print(mydic)
print()
print(mydic.items()) #[('파이썬', '뱀'), ('스프링', 123), ('오라클', '예언자')        ]
print(mydic.keys())
print(mydic.values())    