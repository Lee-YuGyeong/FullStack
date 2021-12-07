<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//DB에 저장된 문자열이라고 가정하자
	String hobby="piano/game/reading";
	String food="ramen,hamburger,pizza";
	//응답에 필요한 데이터(Model)을 request영역에 담는다.
	request.setAttribute("hobby", hobby);
	request.setAttribute("food", food);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jstl/test.jsp</title>
</head>
<body>
	<h1>취미입니다.</h1>
	<ul>
		<c:forTokens var="tmp" items="${hobby }" delims="/">
			<li>${tmp }</li>
		</c:forTokens>
	</ul>

	<h1>좋아하는 음식입니다.</h1>
	<ul>
		<c:forTokens var="tmp" items="${food }" delims=",">
			<li>${tmp }</li>
		</c:forTokens>
	</ul>

</body>
</html>