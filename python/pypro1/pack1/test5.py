# 조건 판단문 if
var = 5

if var>=3:
    print('크구나') #들여쓰기로 블록을 결정
    print('참일 떄')

    
print('end1')
print()

if var>=3:
    #print('크구나')
    #print('참일때')
    pass #해달 조건일떄 아무것도 수행하지 않으려면
    print('dd')
else:
    print('거짓일 때')
    
print('end2')

print()

jumsu = 88 # 동적
if jumsu >= 90:
    print('우수')
else:
    if jumsu >= 70:
        print('보통')
    else:
        print('저조')
print()

if jumsu >= 90:
    print('우수2')
elif jumsu >= 70:
    print('보통')
else:
    print('저조')

print()
jum = int(input('점수 입력:')) # 키보드로 문자 입력 받기
print(jum, type(jum))
if 90<= jum <= 100:
    print('좋아')
elif 70 <= jum <= 90:
    print('좋아2')
else:
    print('좋아3')
    
names = ['홍길동','공기밥','주먹밥']
if '홍길동' in names:
    print("너는 내친구")
else:
    print("누구니?")
    
print()
a = 'kbs'
b = 9 if a == 'kbs' else 11
print('b :',b)

print()
a = 11
b = 'mbc' if a == 'kbs' else 'kbs'
print('b :',b)

print()
a = 3
if a<5:
    print(0)
elif a< 10:
    print(1)
else:
    print(2)

print(0 if a<5 else 1 if a<10 else 2)

