<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/test07.jsp</title>
</head>
<body>
	<h1>하고싶은 말을 입력하고 전송버튼을 눌러서 내용을 확인해보세요.</h1>
	<form action="save.jsp" method="post">
		<textarea name="content" id="" cols="30" rows="10"></textarea>
		<br />
		<button type="submit">전송</button>
	</form>
</body>
</html>