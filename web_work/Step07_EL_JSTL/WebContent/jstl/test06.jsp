<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	//sample 데이터
	request.setAttribute("size", 123456789);
	request.setAttribute("price", 2500000);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/test06.jsp</title>
</head>
<body>
	<p>파일의 크기는 <strong>${size }</strong>byte 입니다.</p>
	<p>가격은 <strong>${price }</strong>입니다.</p>
	
	<p>
		파일의 크기는 
		<strong>
			<fmt:formatNumber value="${size }"/>
		</strong>
		입니다.
	</p>
	
	<p>
		가격은 
		<strong>
			<fmt:formatNumber value="${price }" type="currency" currencySymbol="$"/>
		</strong>
		입니다.
	</p>
</body>
</html>