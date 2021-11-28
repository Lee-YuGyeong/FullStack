<%@page import="test.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//GET 방식 파라미터로 전달되는 삭제할 회원의 번호 읽어오기
	int num = Integer.parseInt(request.getParameter("num"));
	new MemberDao().delete(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	alert("삭제했습니다!");
	location.href="list.jsp";
</script>
</body>
</html>