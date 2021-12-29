# 정규표현식
# 정규표현식 (Regular expressions) 은 특정한 규칙을 가진 문자열의 집합을 표현하는 데 사용하는 형식 언어이다. 
# 복잡한 문자열의 검색과 치환을 위해 사용되며, Python 뿐만 아니라 문자열을 처리하는 모든 곳에서 사용된다.
# 메타 문자 (Meta characters) : . ^ $ * + ? \ | ( ) { } [ ]  
# [] 문자 클래스 : \d \D \s \s...
# {m,n} 반복 횟수 지정
# ...

import re # 정규표현식 모듈 로딩

ss = "1234 abc 가나다 ABC_555_6_678'Python is fun.'123"
print(ss)
print(re.findall(r'123', ss))
print(re.findall(r'가나', ss))
print(re.findall(r'[1,2]',ss))
print(re.findall(r'[1-9]',ss))
print(re.findall(r'[1-9]+',ss))
print(re.findall(r'[1-9]?',ss))
print(re.findall(r'[1-9]*',ss))

print(re.findall(r'\d',ss))
print(re.findall(r'\d+',ss))
print(re.findall(r'\D',ss))
print(re.findall(r'^\d',ss)) # 최초의 숫자
print(re.findall(r'[^1-9]',ss)) #[]안에 ^은 부정
print(re.findall(r'\d$',ss)) #마지막의 숫자
print(re.findall(r'[가-힣]',ss)) 
print(re.findall(r'[가-힣]+',ss)) 
print(re.findall(r'[가-힣,0-9,a-z]+',ss)) 
print(re.findall(r'\d{2}',ss))
print(re.findall(r'\d{2,3}',ss))
#...연습이 필요