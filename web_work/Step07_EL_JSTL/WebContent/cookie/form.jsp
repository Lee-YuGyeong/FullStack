<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cookie/form.jsp</title>
</head>
<body>
	<h1>쿠기(Cookie) 테스트</h1>
	<p>
		클라이언트의 웹브라우저에 특정 key값으로 문자열을 저장할 수 있다.
	</p>
	<form action="save.jsp" method="post">
		<label for="msg">웹브라우저(client side)에 저장할 문자열</label>
		<input type="text" name="msg" id="msg" />
		<button type="submit">저장</button>
	</form>
		
	
	
</body>
</html>