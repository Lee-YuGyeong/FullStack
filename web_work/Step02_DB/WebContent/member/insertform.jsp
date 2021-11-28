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
	<jsp:param value="member" name="thisPage"/>
</jsp:include>
<div class="container">
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/member/list.jsp">회원목록</a></li>
	    <li class="breadcrumb-item active" aria-current="page">회원추가</li>
	  </ol>
	</nav>
	<h1>회원 추가 폼 입니다.</h1>
	<form action="${pageContext.request.contextPath}/member/insert.jsp" method="post">
		<div class="mb-3">
			<label class="form-label" for="name">이름</label>
			<input class="form-control" type="text" name="name" id="name" />
		</div>
		<div class="mb-3">
			<label class="form-label" for="addr">주소</label>
			<input class="form-control" type="text" name="addr" id="addr"/>
		</div>
		<button class="btn btn-success" type="submit">추가</button>
	</form>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>