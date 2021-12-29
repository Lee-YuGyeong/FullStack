'''
연산자
'''
from dask.array.ufunc import divmod

v1 = 3  # 치환
v1 = v2 = v3 = 4
print(v1, v2, v3)
print(id(v1), id(v2), id(v3))
print('aaa', end=' ')
print('bbb')

v1, v2 = 10, 20
v2, v1 = v1, v2
print(v1, v2)

print()
print('값 할당 packing 연산')
v1, *v2 = [1, 2, 3, 4, 5]
print(v1)
print(v2)

* v1, v2 = [1, 2, 3, 4, 5]
print(v1)
print(v2)

* v1, v2, v3 = [1, 2, 3, 4, 5]
print(v1)
print(v2)
print(v3)

# *v1, *v2, v3 = [1,2,3,4,5] err

print('\n-----------------')
print(5 + 3, 5 - 3, 5 * 3, 5 / 3)
print(5 / 3, 5 // 3, 5 % 3, divmod(5, 3))
print(5 ** 2)

print('연산자 우선 순위 :', 3 + 4 * 5, (3 + 4) * 5)  # () > 산술연산자(*,/ > +,-) > 관계연산자 > 논리연산자 > 치환연산자

print('관계 연산', end=':')
print(5 > 3, 5 == 3, 5 <= 3, 5 != 3)

print('논리 연산', end=':')
print(5 > 3 and 4 < 3, 5 > 3 or 4 < 3, not(5 >= 3))

print('문자열 더하기', end=":")
print('1팀' + '만세' + ",2팀" + "화이팅" + ",3팀" + "아자")
print('파이썬' * 20)

print('나이는' + str(22))  # 형변환 함수 str(), int(), float()
print(int('22') + 10)

print('\n누적')
a = 10
a = a + 1
a += 1
# a++ err 자바의 증감연산자 없다
# ++a 
print('a:', a)
print('부호 변경: ', a, a * -1, -a, +a, - -a, + +a)

print('boolean 처리 :', bool(True), bool(1), bool(-5), bool(12.3), bool('kbs'))
print('boolean 처리 :', bool(False), bool(0), bool(None), bool(''), bool(0.0), bool([]), bool({}))

print('\n 이스케이프 \t 문자 관\b련')
print('aa\tbb')
print(r'aa\tbb')  # r : raq string - 이스케이프 기능을 해제
print('c:\aa\nbc\test.txt')
print(r'c:\aa\nbc\test.txt')

print('\nprint 관련 작업---- ')
print(format(1.5678, '10.3f'))

print('나는 나이가 %d 이다.' % 23)
print('나는 나이가 %s 이다.' % '스물셋')
print('나는 나이가 %d 이고 이름은 %s이다.' % (23, '홍길동'))
print('나는 나이가 %s 이고 이름은 %s이다.' % (23, '홍길동'))
print('나는 키가 %f이고, 에너지가 %d%%.' % (177.7, 100))
print('이름은 {0}, 나이는 {1}'.format('한국인', 33))
print('이름은 {}, 나이는 {}'.format('신선해', 33))
print('이름은 {1}, 나이는 {0}, {1},{1}'.format(34, '강나루'))

