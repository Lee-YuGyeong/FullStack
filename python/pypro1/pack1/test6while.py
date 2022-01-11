#반복문 while
from more_itertools.more import padded
a = 1
while a<=5:
    print(a,end=' ')
    a+=1 # a = a+1
print('반복문 탈출 후  a : ',a)
print()

i=1
while i<=3:
    j=1
    while j<=4:
        print('i:',i,',j:',j)
        j+=1
    i+=1
    
print('/n1~100 사이의 정수중 3의 배수의 합은')
su = 1
hap = 0
while su<101:
    if su%3==0:
        hap+=su
    su+=1
print(hap)
print('종료')

print()
colors = ['red','green','blue']
#colors = ('red','green','blue')
#colors = {'red','green','blue'} #err : 순서 X (인덱싱 불가)
print(len(colors))
c=0
while c<len(colors):
    print(colors[c],end = ' ^!^;')
    c+=1

print()
import time
#time.sleep(3)
sw = input('폭탄 스위치를 누를까요?[y/n]')
if sw == 'Y' or sw == 'y':
    count = 5
    while 1<=count:
        print('%d초 남았어요'%count)
        time.sleep(1)
        count-=1
    print('폭발')
    pass
elif sw == 'N' or sw == 'n':
    print('작업을 취소')
else:
    print('y 또는 n을 누르세요')
print('종료')