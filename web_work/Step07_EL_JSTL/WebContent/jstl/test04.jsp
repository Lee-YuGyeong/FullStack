<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jstl/test04.jsp</title>
</head>
<body>
	<%-- 조건부로 어떤 내용을 클라이언트에게 출력하고자 할때 사용한다. --%>
	<c:if test="${10%2 eq 0 }">
		<p>10은 짝수입니다.</p>
	</c:if>
	<%-- 아래 코드를 대신할 수 있습니다. --%>
	<%if(10%2==0){ %>
		<p>10은 짝수입니다.</p>
	<%} %>
	
	<c:if test="${11%2 eq 0}">
		<p>11은 짝수입니다.</p>
	</c:if>
	
	<c:if test="${empty sessionScope.id }">
		<p>로그인이 필요합니다.</p>
	</c:if>
	
	<c:if test="${not empty sessionScope.id }">
		<p><strong>${sessionScope.id }</strong>님 로그인중...</p>
	</c:if>
</body>
</html>