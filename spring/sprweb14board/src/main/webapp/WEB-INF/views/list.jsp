<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="./resources/css/board.css" type="text/css" />
</head>
<body>
	<table>
		<tr>
			<a href="list?page=1">최근목록</a>]&nbsp; [
			<a href="insert">새글 작성</a>]

		</tr>
	</table>
	<table>
		<tr style="background-color: silver;">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
		</tr>
		<c:forEach var="tmp" items="${data }">
			<tr>
				<td>${tmp.num }</td>
				<td><a href="detail?num=${tmp.num }&page=${page}">${tmp.title }</a>
				</td>
				<td>${tmp.name }</td>
				<td>${tmp.bdate }</td>
				<td>${tmp.readcnt }</td>
			</tr>
		</c:forEach>
		<!-- paging -->
		<tr style="text-align: center;">
			<td colspan="5">
				<c:forEach var="psu" begin="1" end="${pagesu }">
					<c:if test="${psu == page }"> <!-- 현재 페이지는 링크에서 제외 -->
						<b>${psu }</b>
					</c:if>
					<c:if test="${psu != page }">
						<a href="list?page=${psu }">${psu }</a>
					</c:if>
				</c:forEach>
			</td>
		</tr>

		<!-- search -->
		<tr style="text-align: center;">
			<td colspan="5"><br /> <br />
				<form action="search" method="post">
					<select name="searchName">
						<option value="title" selected="selected">글제목</option>
						<option value="name">작성자</option>
					</select> <input type="text" name="searchValue" /> <input type="submit"
						value="검 색" />
				</form></td>
		</tr>
	</table>


</body>
</html>