<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
성적을 입력하세요<p/>
<form action="score" method="post">
	국어 : <input type="text" name="kor"><br>
	영어 : <input type="text" name="eng"><br>
	수학 : <input type="text" name="math"><br>
	<br>
	<input type="submit" value="전송">
</form>
</body>
</html>