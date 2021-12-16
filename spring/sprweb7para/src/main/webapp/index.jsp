<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
* 요청 파라미터 연습 *<p/>
<a href="kbs/login?type=admin">관리자</a>
<a href="kbs/login?type=user">일반인</a>
<a href="kbs/login?">파라미터 없음</a>
<br>
<form action="kbs/login" method="post">
	data : <input type="text" name="type" value="user">
	<input type="submit" value="전송" >
</form>

<hr>* 요청 URL, 파라미터로 정보를 전달하기  *
<form action="mbc/korea" method="post">
	data : <input type="text" name="name" value="tom">
	<input type="submit" value="전송" >
</form>
<br>
<form action="mbc/usa" method="post">
	data : <input type="text" name="name" value="james">
	<input type="submit" value="전송" >
</form>
<hr>* 요청 URL, 파라미터로 정보를 전달하기2  *
<form action="ent/bighit/singer/bts" method="get">
	신곡 : <input type="text" name="title" value="퍼미션 투 댄스">
	<input type="submit" value="전송" >
</form>
<br>
<form action="ent/yg/singer/blackpink" method="get">
	신곡 : <input type="text" name="title" value="붐바야">
	<input type="submit" value="전송" >
</form>
</body>
</html>