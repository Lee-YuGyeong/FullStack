<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 상품 정보(@MVC - MyBatis) **<p/>
<table border="1">
	<tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th></tr>
	<c:forEach var="s" items="${datas }">
	<tr>
		<td>${s.code }</td>
		<td>${s.sang }</td>
		<td>${s.su }</td>
		<td>${s.dan }</td>
	</tr>
	</c:forEach>
	<!-- 검색 -->
	<tr>
		<td colspan="4">
			<form action="search" method="post">
			상품명 : <input type="text" name="searchValue">
			<input type="submit" value="검 색">
			</form>
		</td>
	</tr>
</table>
</body>
</html>