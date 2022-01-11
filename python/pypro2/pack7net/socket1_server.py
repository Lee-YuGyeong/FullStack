# socket 통신 : Echo 서버용 - 접속 상태 확인을 위해 1개의 접속만 처리

from socket import *

serversock = socket(AF_INET,SOCK_STREAM)
serversock.bind(('127.0.0.1',9999))
serversock.listen(1)
print('server start ...')

conn, addr = serversock.accept() # 수동적으로 클라이언트의 접속 대기
print('conn : ',conn)
print('addr : ',addr)
print('from client msg :', conn.recv(1024).decode())

conn.close()
serversock.close()