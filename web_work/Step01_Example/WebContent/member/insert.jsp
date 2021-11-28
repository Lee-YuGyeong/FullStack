<%@page import="test.dao.MemberDao"%>
<%@page import="test.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	MemberDto dto = new MemberDto();
	dto.setName(name);
	dto.setAddr(addr);
	new MemberDao().insert(dto);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/insert.jsp</title>
</head>
<body>
<p>회원정보를 추가할 수 있을까?<%=name %></p>
<a href="/Step01_Example/member/list.jsp">목록보기</a>
</body>
</html>