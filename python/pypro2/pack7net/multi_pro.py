# 프로세스 기반 병렬 처리 : 비동기적, 비 결정적 작업에 효과적
# Pool 클래스 연습 : 함수 실행을 병렬로 처리해 주는 클래스

from multiprocessing import Pool
import time
import os

def func(x):
    print('값 ',x,'에 대한 작업 pid : ', os.getpid()) # 현재 진행되고 있는 프로세스 아이디 확인
    time.sleep(1)
    return x * x # 입력된 매개 변수 값을 제공해서 반환

if __name__ == '__main__':
    p = Pool(processes=3) # 3~5개 적당
    
    startTime = int(time.time())
    
    '''
    for i in range(0,10): # 일반적인 방법으로 함수 호출 : 직렬 (순차적으로 하나의 프로세스 사용)
        print(func(i))
    '''
    
    print(p.map(func,range(0,10))) # 함수와 인자값을 매핑해서 데이터를 분배해 프로세스 처리
        
    endTime = int(time.time())
    print('총 소요시간 : ',(endTime - startTime))
    