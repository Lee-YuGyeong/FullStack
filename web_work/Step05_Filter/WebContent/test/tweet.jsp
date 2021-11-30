<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//post 방식 전송했을때 한글 깨지지 않도록

	String msg=request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/tweet.jsp</title>
</head>
<body>
	<p>전송된 문자열: <strong><%=msg %></strong></p>
</body>
</html>