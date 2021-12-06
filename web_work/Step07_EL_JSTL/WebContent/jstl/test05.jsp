<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//테스트를 위해 sample 데이터를 request scope에 담기
	request.setAttribute("jumsu", 90);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jstl/test05.jsp</title>
</head>
<body>
	<p>획득한 점수는 <strong>${jumsu }</strong>입니다.</p>
	<p>
		학점은
		<c:choose>
			<c:when test="${jumsu ge 90 }">A</c:when>
			<c:when test="${jumsu ge 80 }">B</c:when>
			<c:when test="${jumsu ge 70 }">C</c:when>
			<c:when test="${jumsu ge 60 }">D</c:when>
			<c:otherwise>F</c:otherwise>
		</c:choose>
		입니다
	</p>
	
	<%-- 아래와 같은 형식으로 if-else의 모직을 구현할 수 있다. --%>
	<c:choose>
		<c:when test="${empty id }">
			<p>로그인이 필요합니다.</p>
		</c:when>
		<c:otherwise>
			<p><strong>${id}</strong>님 로그인중...</p>
		</c:otherwise>
	</c:choose>
</body>
</html>