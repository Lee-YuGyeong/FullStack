# 클라이언트
import socket

clientsock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
clientsock.connect(('127.0.0.1', 8888))
clientsock.send('안녕 난 클라이언트야'.encode('utf-8'))
re_message = clientsock.recv(1024).decode()

print('수신 자료 : ',re_message)
clientsock.close()