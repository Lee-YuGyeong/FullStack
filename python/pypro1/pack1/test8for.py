# 반복문 for
#for i in [1,2,3,4,5]:
#for i in (1,2,3,4,5):
from anaconda_project.internal.conda_api import result
for i in {1,2,3,4,5,1,2,3,4,5}:    #중복 불가
    print(i, end='-')
print('\n')
soft = {'java':'웹용 언어','python':'만능언어','go':'속도빠름'} #dict
for i in soft.items():
    print(i) #('java','웹용언어')...
    print(i[0],i[1])
    
print()    
for i in soft.keys():
    print(i) #('java','웹용언어')...
    print(i[0],i[1])

print()    
for i in soft.values():
    print(i)

print()
for k,v in soft.items():
    print('key : ',k)
    print('value : ',v)
    
print()
numbers = [1,3,5,7,9] # 얘네들의 합은
numbers = [3,4,5,6,7]
numbers = [-3,4,5,6,13]
tot = 0
for abc in numbers:
    tot += abc
print('얘네들의 합은 '+str(tot)+'입니다')
print('평균은 ', tot / len(numbers))

print()
for index, value in enumerate(numbers): # 인덱스와 값을 얻음
    print(str(index)+"번째 값은 "+str(value))

print('\n다중 for ---')
for dan in [2,3]:
    print('--{}단---'.format(dan))
    for su in [1,2,3,4,5,6,7,8,9]:
        print('{0} * {1} = {2} '.format(dan,su,dan*su))

print('\ncontinue, break -----------')
datas = [1,2,3,4,5]
for kbs in datas:
    if kbs == 2: continue
    if kbs == 4: break
    print(kbs, end = ' ')

print()
jumsu = [95,70,60,55,100]
number = 0

for jum in jumsu:
    number += 1
    if jum < 70: continue
    print('%d번째 점수는 합격'%number)
    
print()
li1 = [3,4,5]
li2 = [0.5,1,2]
result = [] # list type 변수 선언
for a in li1:
    for b in li2:
        #print(a + b, end = ', ')
        result.append(a+b)
print(result)

#Comprehension 기능 사용
result2 = [a+b for a in li1 for b in li2]
print(result2)

print()
a = [1,2,3,4,5,6,7,8,9,10]
li = []
for i in a:
    if i%2==0:
        li.append(i)
print(li)

print(list(i for i in a if i%2==0))
print([i for i in a if i%2==0])

print()
#datas = [1,2,'a',True,3.5]
#datas = (1,2,1,2,'a',True,3.5)
datas = {1,2,1,2,'a',True,3.5}
li = [i for i in datas if type(i)==int]
print(li)

print()
id_name = {1:'tom',2:'john'}
name_id = {v:k for k,v in id_name.items()}
print(name_id)

print('과일 값 계산----')
price = {'사과':1000,'감':500,"오렌지":1200} # 오늘의 과일 시세
guest = {'사과':2, '감':4} # 손님이 구매한 내역
#sum() : 합을 구하는 내장 함수
bill = sum(price[f]*guest[f] for f in guest)
print('과일 가격 총액 : {}원'.format(bill))


print('-----')
aa = [(1,2),(3,4),(5,6)]
for a,b in aa:
    print(a+b, end=' ')
print('종료')