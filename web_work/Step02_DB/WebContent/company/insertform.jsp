<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/include/navbar.jsp">
	<jsp:param value="company" name="thisPage"/>
</jsp:include>
<div class="container">
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/company/list.jsp">사원목록</a></li>
	    <li class="breadcrumb-item active" aria-current="page">사원추가</li>
	  </ol>
	</nav>
	<h1>사원 추가 폼 입니다.</h1>
	<form action="${pageContext.request.contextPath}/company/insert.jsp" method="post">
		<div class="mb-3">
			<label class="form-label" for="ename">사원 이름</label>
			<input class="form-control" type="text" name="ename" id="ename" />
		</div>
		<div class="mb-3">
			<label class="form-label" for="job">직책</label>
			<input class="form-control" type="text" name="job" id="job"/>
		</div>
		<div class="mb-3">
			<label class="form-label" for="hiredate">입사일</label>
			<input class="form-control" type="text" name="hiredate" id="hiredate"/>
		</div>
		<button class="btn btn-success" type="submit">추가</button>
	</form>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>