<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 꺠지지 않도록
	request.setCharacterEncoding("utf-8");
	//post 방식 전송되는 이름과 주소를 읽어들여서
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	//DB에 저장하고
	MemberDto dto = new MemberDto();
	dto.setName(name);
	dto.setAddr(addr);
	boolean isSuccess=MemberDao.getInstance().insert(dto);
	//응답하기
	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/insert.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<h1>알림</h1>
	<% if(isSuccess){ %>
		<p class="alert alert-success">
			<strong><%=name %></strong>의 정보를 추가했습니다.
			<a class="alert-link" href="list.jsp">확인</a>
		</p>
	<%}else{ %>
		<p class="alert alert-warning">
			회원 정보 추가 실패! <a class="alert-link" href="insertform.jsp">다시시도</a>
		</p>
	<%} %>

</div>
</body>
</html>