<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	** 게시판 글쓰기 **
	<p />
	<form action="write" method="post">
		글 제목 : <input type="text" name="title"><br> 작성자 : <input
			type="text" name="author"><br> 글 내용 :
		<textarea rows="10" cols="30" name="content"></textarea>
		<br> <br> <input type="submit" value="저장">
	</form>
</body>
</html>