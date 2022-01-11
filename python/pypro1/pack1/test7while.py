# while : continue, break

a=0

while a <10:
    a += 1
    if a == 3 or a ==5: continue
    if a == 7:break
    print(a)
    
print('\n 컴퓨터가 가진 임의의 숫자 알아 맞추기')
# 난수 1, 3, 5 .. 생성
import random
#random.seed(123)
print(random.random())
print(random.randint(1,10)) # 1~ 10 사이의 실수 출력

num = random.randint(1, 10)
while True:
    print('고객님 컴퓨터는 1 ~10 중 어떤값을 가졌을까요? ')
    guess = int(input('입력:'))
    if guess ==num:
        print('와우 성공~~' * 5)
        break
    elif guess < num:
        print('더 큰수를 입력하세요')
    elif guess > num:
        print('더 작은수를 입력하세요')

    
print('종료')