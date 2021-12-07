<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//글 목록을 얻어오기
	List<GuestBookDto> list=GuestBookDao.getInstance().getList();
	//EL을 이용해서 글 목록을 추출할 수 있도록 request 영역에 담아둔다.
	request.setAttribute("list", list);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/list.jsp</title>
</head>
<body>
<div class="container">
	<a href="insertform.jsp">새글 작성</a>
	<h1>방명록 글 목록입니다.</h1>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.writer }</td>
					<td>
						<a href="detail.jsp?num=${tmp.num }">${tmp.title }</a>
					</td>
					<td>${tmp.regdate }</td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>