<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session scope(영역)에 "id"라는 키값으로 String type 담기
	session.setAttribute("id","kimgura");

	//위의 코드는 로그인할때 로그인을 처리하는 페이지에서 실행되었다고 가정하자
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/el/test03.jsp</title>
</head>
<body>
	<%
		String result=(String)session.getAttribute("id");
	%>
	<p><strong><%=result %></strong>님 로그인중...</p>
	<p><strong>${sessionScope.id }</strong>님 로그인중...</p>
	<p><strong>${id }</strong>님 로그인중...</p>
</body>
</html>