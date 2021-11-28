<%@page import="test.company.dao.CompanyDao"%>
<%@page import="test.company.dto.CompanyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 꺠지지 않도록
	request.setCharacterEncoding("utf-8");
	//post 방식 전송되는 이름과 주소를 읽어들여서
	String ename = request.getParameter("ename");
	String job = request.getParameter("job");
	String hiredate = request.getParameter("hiredate");
	//DB에 저장하고
	CompanyDto dto = new CompanyDto();
	dto.setEname(ename);
	dto.setJob(job);
	dto.setHiredate(hiredate);
	boolean isSuccess = CompanyDao.getInstance().insert(dto);
	//응답하기
	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/company/insert.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<h1>알림</h1>
	<% if(isSuccess){ %>
		<p class="alert alert-success">
			<strong><%=ename %></strong>의 사원 정보를 추가했습니다.
			<a class="alert-link" href="list.jsp">확인</a>
		</p>
	<%}else{ %>
		<p class="alert alert-warning">
			사원 정보 추가 실패! <a class="alert-link" href="insertform.jsp">다시시도</a>
		</p>
	<%} %>

</div>
</body>
</html>