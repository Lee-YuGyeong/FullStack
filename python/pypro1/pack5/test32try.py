# 예외 처리

def divideFunc(a,b):
    return a/b

print('뭔가를 하다가...')
'''
c=divideFunc(5, 2)
#c=divideFunc(5, 0)
print(c)
'''

try:
    c=divideFunc(5, 2)
    #c=divideFunc(5, 0)
    print(c)
    
    aa=[1,2]
    print(aa[0])
    #print(aa[2])
    
    f=open('c:/work/sbs.txt')
    
except ZeroDivisionError:
    print('두번째 숫자는 0이면 안돼~')
except IndexError as err:
    print('허걱 에러 :',err)
except Exception as e:
    print('아뿔싸 에러 ㅠㅠ :',e)
finally:
    print('에러 유무에 상관 없이 꼭 처리할 내용은 여기에 적음')

print('종료')





























