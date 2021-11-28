<%@page import="test.company.dao.CompanyDao"%>
<%@page import="test.company.dto.CompanyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 깨지지 않도록
	request.setCharacterEncoding("utf-8");
	//1. 폼 전송된 수정할 회원의 정보를 읽어온다.
	int empno = Integer.parseInt(request.getParameter("empno"));
	String ename = request.getParameter("ename");
	String job = request.getParameter("job");
	//2. DB에 수정반영한다.
	CompanyDto dto = new CompanyDto();
	dto.setEmpno(empno);
	dto.setEname(ename);
	dto.setJob(job);
	CompanyDao.getInstance().update(dto);
	//3. 응답한다.
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/update.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<h1>알림</h1>
	<p class="alert alert-success">사원정보를 수정했습니다.
		<a class="alert-link" href="list.jsp">확인</a>
	</p>
	
</div>
</body>
</html>