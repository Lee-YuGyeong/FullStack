<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로직을 사용할 수 있다.
	/*
		<jsp:include page="/include/navbar.jsp">
			<jsp:param value="index or member or company" name="thisPage"/>
		</jsp:include>
		위와 같은 형식으로 파라미터가 전달된다.
	
	*/
	String thisPage = request.getParameter("thisPage");
	System.out.println(thisPage);
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Acorn</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-link <%=thisPage.equals("member") ? "member active" : "" %>" href="${pageContext.request.contextPath}/member/list.jsp">회원목록</a>
				<a class="nav-link <%=thisPage.equals("company") ? "company active" : "" %>" href="${pageContext.request.contextPath}/company/list.jsp">사원목록</a>
			</div>
		</div>
	</div>
</nav>