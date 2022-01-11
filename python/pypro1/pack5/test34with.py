# file i/o 에서 with 블럭 사용하기

try:
    #파일 저장 : close() 문은 자동 처리됨
    with open('ftest3.txt', mode='w', encoding='UTF-8') as f1:
        f1.write('파이썬으로 문서 저장\n')
        f1.write('with 구문을\n')
        f1.write('사용하면 close() 필요없다 라고 태석에게 알림\n')
    print('저장 완료')
    
    print()
    #파일 읽기
    with open('ftest3.txt', mode='r', encoding='UTF-8') as f2:
        print(f2.read())
    
except Exception as e:
    print('에러 :',e)
    
print('\n피클링 (일반 객체 및 복합 객체 처리)---object type으로 저장')
import pickle

try:
    dicdata={'tom':'111-1111', '현하':'222-2222'}
    listdata=['충만', '병상']
    tupledata=(dicdata, listdata)   #복합 개체
    
    with open('hello.dat', mode='wb') as f3:
        pickle.dump(tupledata, f3)
        pickle.dump(listdata, f3)
    print('객체를 파일로 저장')
    
    print('피클로 저장된 객체 읽기')
    with open('hello.dat', mode='rb') as f4:
        a, b = pickle.load(f4)
        print(a)
        print(b)
        c=pickle.load(f4)
        print(c)
    
except Exception as e:
    print('에러 :',e)






















