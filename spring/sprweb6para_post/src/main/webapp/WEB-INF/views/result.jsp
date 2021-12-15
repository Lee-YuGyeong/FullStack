<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Post 방식 처리 결과 <p/>
${msg }
<hr>
우리 팀장님 이름 출력<br>
전통적 방법 : <br>
<%
	ArrayList<String> list = (ArrayList)request.getAttribute("team");
	for(String t:list){
		out.print(t + "&nbsp;&nbsp;");
	}
%>
<br>
JSTL 방법 : <br>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="t" items="${team }">
	${t }&nbsp;&nbsp;
</c:forEach>
</body>
</html>