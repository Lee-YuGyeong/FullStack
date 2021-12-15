<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
* 로그인 자료 전송 *<p/>
<a href="login?id=aa&pwd=123">로그인</a>
<br>
<form action="login" method="get">
	아 이 디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pwd"><br>
	<input type="submit" value="전송(get)">
	
</form>
</body>
</html>