# 서버에 접속해 메세지를 전달하는 클라이언트 역할

from socket import *

clientsock = socket(AF_INET,SOCK_STREAM)
clientsock.connect(('127.0.0.1',9999)) # 능동적으로 서버에 접속
clientsock.send('안녕 반가워'.encode(encoding='utf-8',errors='strict'))
clientsock.close()
