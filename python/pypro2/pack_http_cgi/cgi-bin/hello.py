# 웹용 파이썬 모듈

#파이썬 작업을 하다가 내용을 클라이언트 브라우저로 출력
ss = '파이썬 만세'
kor = 90
eng = 80

print('Content-Type:text/html;charset=utf-8\n')
print('<html>')
print('<body>')
print('<b>안녕</b> 파이썬 모듈로 작성한 페이지입니다.<br>')
print('파이썬 변수 값 출력 : %s'%(ss, ))
print('<br>')
print('국어 점수는 %s, 영어점수는 %s'%(kor,eng))
print('<br><a href="../index.html">메인으로</a>')
print('</body>')
print('</html>')