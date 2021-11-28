<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%-- navbar.jsp 포함시키기 --%>
<jsp:include page="/include/navbar.jsp">
	<jsp:param value="index" name="thisPage"/>	
</jsp:include>

<div class="container">  
	<h1>인덱스 페이지 입니다.</h1>
	<p>컨텍스트 경로 : <strong>${pageContext.request.contextPath}</strong></p>
	<ul>
		<!-- 상대 경로 이동 -->
		<li><a href="member/list.jsp">회원목록 보기</a></li>
		<!-- 절대 경로 이동 -->
		<li><a href="/Step02_DB/member/list.jsp">회원목록 보기</a></li>
		<li><a href="${pageContext.request.contextPath}/member/list.jsp">회원목록 보기</a></li>
		<li><a href="/member/list.jsp">회원목록 보기</a></li>
		
	</ul>
</div>
<%-- 
	jsp가 무시하는 페이지에서의 주석영역
--%>
 
<!-- 
 	웹브라우저가 무시하는 html 페이지 내에서의 주석영역

-->
<%--
	include 될 페이지의 위치를  지정할때
	상대경로, 절대경로 모두 사용가능하다.
	단, 주의할점은 절대경로에서 /는 WebContent를 가리킨다.
	context path는 넣으면 안된다.
	(context path 는 클라이언트가 요청하는 경로이고, jsp:include는 클라이언트와 상관없이
	서버에서 해석되는 부분이기 때문에 context path가 의미가 없는 것이다.)
--%>
<jsp:include page="/include/footer.jsp"></jsp:include>

</body>
</html>