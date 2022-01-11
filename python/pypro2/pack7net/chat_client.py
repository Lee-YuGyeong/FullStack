# chat client
import socket
import threading
import sys

def handle(socket):
    while True:
        data = socket.recv(1024)
        if not data: continue
        print(data.decode('utf-8'))
         
sys.stdout.flush() # buffer를 비움


name = input('채팅 아이디 입력 : ')
cs = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
cs.connect(('127.0.0.1',5555))
cs.send(name.encode('utf-8'))

th = threading.Thread(target=handle, args = (cs, ))
th.start() # 서버가 전송한 데이터를 수신해서 출력하기를 스레드를 사용
while True:
    msg = input(':') # 채팅 메세지 입력
    sys.stdout.flush()
    if not msg: continue
    cs.send(msg.encode('utf-8'))

cs.close()
    
