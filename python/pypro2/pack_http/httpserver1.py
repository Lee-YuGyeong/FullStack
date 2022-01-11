# SimpleHTTPRequestHandler를 이용해 GET 요청처리 수행
# HTTPServer를 이용해 웹 서버를 구축

from http.server import SimpleHTTPRequestHandler, HTTPServer

port = 7777

handler = SimpleHTTPRequestHandler
serv = HTTPServer(('127.0.0.1',port), handler)
print('웹 서비스 시작...')
serv.serve_forever() # 웹 서비스 시작
