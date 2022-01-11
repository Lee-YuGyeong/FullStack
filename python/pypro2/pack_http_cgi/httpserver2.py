# SimpleHTTPRequestHandler 기능을 확장한 클래스 CGIHTTPRequestHandler를 사용
# GET, POST 처리 모두 가능
# CGI를 지원
# CGI란 common gate way interface의 약어로 WWW 서버와 서버 상에서 등장하는 
# 다른 프로그램이나 스크립트와의 인터페이스 폼을 사용한 메일의 송신이나 게임 등 
# HTML에서는 불가능한 인터렉티브한 요소를 홈페이지에 받아 들여 쓸 수 있다.

from http.server import CGIHTTPRequestHandler, HTTPServer

port = 7788

class Handler(CGIHTTPRequestHandler):
    cgi_directories = ['/cgi-bin']
    
serv = HTTPServer(('127.0.0.1',port),Handler)

print('나의 웹서버 서비스 시작...')
serv.serve_forever()