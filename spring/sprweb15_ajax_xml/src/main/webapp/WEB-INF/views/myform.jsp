<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전송된 자료 그대로 반환받기<br />
	<form action="member" method="post">
		name :  <input type="text" name="name" value="tom"/><br />
		age :  <input type="text" name="age" value="33"/><br /><br />
		<input type="submit" />
	</form>
	
	<hr />
전송된 자료 xml로 변환해 반환받기<br />
	<form action="member_xml" method="post">
		name :  <input type="text" name="name" value="john"/><br />
		age :  <input type="text" name="age" value="27"/><br /><br />
		<input type="submit" />
	</form>
	
</body>
</html>