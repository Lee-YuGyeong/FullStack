<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
	
	//post방식 전송되는 파라미터 추출
	String msg = request.getParameter("msg");
	System.out.println("클라이언트가 전송한 문자열 : " +msg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	okay~
	<%=msg %>
</body>
</html>