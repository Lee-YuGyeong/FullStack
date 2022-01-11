#range() 함수로 수열 생성
print(list(range(1,6,1)))
print(list(range(1,6)))
print(list(range(1,6,2)))
print(list(range(6)))
print(tuple(range(1,6)))
print(set(range(1,6)))
print(tuple(range(-10,-100,-20)))

print()
for i in range(6):
    print(i,end=' ')
    
print()
for _ in range(3):
    print('변수 사용 안할래')

print('1 ~ 100 까지의 정수의 합')
tot = 0
for a in range(1,101):
    tot += a
print('합은 ',tot) #프로그램으로 결과 확인
print('합은 ',sum(range(1,101)))  # 내장함수로 결과 확인 또는 함수를 만들어 사용해도됨

print('1 ~ 100 까지의 정수중 3의 배수이고 5의 배수의 합')
tot = 0
for a in range(1,101):
    if a%3==0 and a%5==0:
        tot += a
print('합은 ',tot)


print('\n2 ~ 5 단 구구단 출력')
for i in range(2,6):
    for j in range(1,10):
        print('{}*{}={}'.format(i,j,i*j), end=' ')
    print()
    
print('\n 주사위를 두번 던져 나온 숫자들의 합이 4의 배수인 경우만 출력')
for i in range(1,7):
    for j in range(1,7):
        su = i+j
        if su % 4==0:
            print(i,j)
            