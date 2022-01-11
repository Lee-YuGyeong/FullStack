# 네트워킹 : 컴퓨터 간 데이터 통신
# socket 클래스 : 네트워크를 위한 통신 채널. TCP/IP 프로토콜(통신규약)의 프로그래머 인터페이스(API)
# 연결지향 소켓으로 양방향 통신이 가능.

# socket 통신 확인
import socket

print(socket.getservbyname('http','tcp')) # http port number : 80
print(socket.getservbyname('telnet','tcp')) # 원격컴퓨터 접속용 23
print(socket.getservbyname('ssh','tcp')) # 원격컴퓨터 접속용 22
print(socket.getservbyname('ftp','tcp')) # 파일 전송용 21
print(socket.getservbyname('smtp','tcp')) # 메일 송수신 25
print(socket.getservbyname('pop3','tcp')) # 메일 송수신 110

# 특정 domain server에 접속해서 ip 주소 얻기
print(socket.getaddrinfo('www.naver.com', 80, proto = socket.SOL_TCP))