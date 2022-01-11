# 파이썬은 인터프리터 언어로써 기본적으로 싱글 쓰레드에서 순차적으로 동작한다.
# 따라서 병렬처리를 하기 위해서는 별도의 무듈을 사용하여 구현해야한다.

import threading, time

def run(id):    # 스레드 대상 함수
    for i in range(1, 11):
        print('id={} --> {}'.format(id, i))
        time.sleep(0.5)
# thread를 안 쓴 경우. 순차적으로 함수를 실행(직렬)
#run('일')
#run('둘')

#thread를 쓴 경우, 함수를 실행(병렬) - 사용자 정의 스레드
th1 = threading.Thread(target=run, args=('하나',)) # 튜플로 줘야함
th2 = threading.Thread(target=run, args=('두울',)) # 튜플로 줘야함
th1.start() # 스레드 실행 - 스레드 스케줄러(랜덤하게 처리)
th2.start()

th1.join() # 사용자 정의 스레드가 종료될 때 까지 메인스레드의 종료를 대기
th2.join()

print('프로그램 종료')
