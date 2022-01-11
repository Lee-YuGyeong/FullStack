# 서버 서비스는 계속 유지. 클라이언트는 일회용
import socket

serversock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
PORT=8888
try:
    serversock.bind(('127.0.0.1',PORT))
    serversock.listen(5) # 접속 대기. 동시 접속 최대 수 1~5까지
    print('에코서버 서비스 중...')
    
    while True:
        conn,addr = serversock.accept() # 클라이언트의 접속 승인
        print('클라이언트 정보:', addr[0],addr[1]) # ip 주소, port 번호
        print(conn.recv(1024).decode()) # 클라이언트의 메세지를 수신
        
        # 서버가 클라이언트로 메세지 송신
        conn.send(('서버가 클라이언트에게 : '+str(addr[1])+' 너도 잘 지내라').encode('utf-8'))
        
except Exception as e:
    print('err : ',e)
finally:
    serversock.close()