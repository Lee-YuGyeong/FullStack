# 멀티 채팅 서버
import socket
import threading

ss = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
ss.bind(('127.0.0.1',5555))
ss.listen(5)
print('채팅 서버 서비스 시작 ...')

users = [] # 채팅에 참여한 컴퓨터 접속 socket이 담길 리스트형 변수

def charUser(conn):
    name = conn.recv(1024)
    data = '^^ ' + name.decode('utf-8') + '님 입장 ^^'
    print(data)

    try:
        for p in users:
            p.send(data.encode('utf-8'))
            
        while True: # 채팅 접속자들 간에 수다 떨기
            msg = conn.recv(1024)
            data = name.decode('utf-8') + '님 메세지:'+msg.decode('utf-8')
            print('접속자 간 수다 내용 : ',data)
            for p in users:
                p.send(data.encode('utf-8'))
                         
    except:
        users.remove(conn)
        data = 'ㅠㅠ' + name.decode('utf-8') + '님 퇴장~~' 
        print(data)
        if users:
            for p in users:
                p.send(data.encode('utf-8'))
        else:
            print('exit')            

while True:
    conn,addr = ss.accept()
    users.append(conn)
    th = threading.Thread(target=charUser, args=(conn,))
    th.start()