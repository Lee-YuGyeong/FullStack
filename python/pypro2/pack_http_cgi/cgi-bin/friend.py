# 서버는 사용자가 전송한 자료를 받아 다시 브라우저로 출력하기
import cgi

form = cgi.FieldStorage() # 사용자가 전송한 자료를 받음. dict type으로

name = form["name"].value # java 에서는 request.getParameter("name")
phone = form["phone"].value
gender = form["gen"].value

print('Content-Type:text/html;charset=utf-8\n')
print("""
<html>
<head>
이름은 {0}, 전화는 {1}, 성별은 {2}
</body>
</html>
""".format(name, phone, gender))