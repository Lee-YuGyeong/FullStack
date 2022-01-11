# 스레드의 활성화, 비활성화
import threading, time

bread_plate = 0 # 스레드의 공유 자원 : 빵 접시에 빵은 최대 10개까지 담을 수 있다.
lock = threading.Condition() # lock을 위한 조건 변수

class Maker(threading.Thread): # 빵 생산자
    def run(self):
        global bread_plate
        for i in range(30): # 30번 반복
            lock.acquire()  # 공유자원 충돌 방지를 목적으로 lock을 걸기
            while bread_plate >= 10:
                print('빵 생산 초과로 생산 대기')
                lock.wait() # 스레드 비활성화
            bread_plate += 1
            print('빵 생산 : ', bread_plate)
            lock.notify() # 스레드 활성화. wait()를 해제
            lock.release() # lock을 풀기
            time.sleep(0.05)
            
class Consumer(threading.Thread): # 빵 소비자
    def run(self):
        global bread_plate
        for i in range(30): # 30번 반복
            lock.acquire()  # 공유자원 충돌 방지를 목적으로 lock을 걸기
            while bread_plate < 1:
                print('빵이 없어 기다림..')
                lock.wait() # 스레드 비활성화
            bread_plate -= 1
            print('빵 소비 : ', bread_plate)
            lock.notify() # 스레드 활성화. wait()를 해제
            lock.release() # lock을 풀기
            time.sleep(0.05)

mak = []
con = []

for i in range(5): # 생산자 수
    mak.append(Maker())

for i in range(5): # 소비자 수
    con.append(Consumer())

for th1 in mak:
    th1.start() # 스레드 시작

for th2 in con:
    th2.start() # 스레드 시작
    
for th1 in mak:
    th1.join()

for th2 in con:
    th2.join()
    
print('오늘 장사 끝 ~~~')