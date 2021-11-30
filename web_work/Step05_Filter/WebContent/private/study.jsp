<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인된 아이디 읽어오기
	String id=(String)session.getAttribute("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/private/study.jsp</title>
</head>
<body>
	<p>
		<strong><%=id %></strong>님 열심히 공부합니다.
	</p>
	<a href="../index.jsp">인덱스로 가기</a>
</body>
</html>