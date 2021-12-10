<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	//GET 방식 파라미터로 전달되는 글 번호를 읽어온다. detail.jsp?num=x
	int num=Integer.parseInt(request.getParameter("num"));
	//DB에서 해당글의 정보를 얻어온다.
	GuestBookDto dto=GuestBookDao.getInstance().getData(num);
	//응답에 필요한 데이터(Model)을 request 영역에 담는다.
	request.setAttribute("dto", dto);
	//글하나의 정보를 적당한 포맷으로 응답한다.
	pageContext.setAttribute("newLine", "\n");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/detail.jsp</title>
</head>
<body>
<div class="container">
	<a href="list.jsp">목록보기</a>
	<h1>글 자세히 보기 페이지</h1>
	<table>
		<tr>
			<th>번호</th>
			<td>${dto.num }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="30" rows="10" disabled="disabled">${dto.content }</textarea></td>
		</tr>
		<tr>
			<th>내용2</th>
			<td>${fn:replace(dto.content,newLine,'<br>' )}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${dto.regdate }</td>
		</tr>
	</table>
	<p>${fn:replace(dto.content,newLine,'<br>' )}</p>

	<form action="updateform.jsp" method="get">
		<input type="hidden" name="num" value="${dto.num }" />
		<input type="password" name="pwd" placeholder="비밀번호..." />
		<button type="submit">수정</button>
	</form>
	<%--
		글을 삭제하기 위해서는 글번호가 필요하게떄문에 글번호를 input type="hidden" 으로
		form 전송될때 같이 전송되도록 한다.
	 --%>
	<form action="delete.jsp" method="post">
		<input type="hidden" name="num" value="${dto.num }"/>
		<input type="text" name="pwd" placeholder="비밀번호..." />
		<button type="submit">삭제</button>
	</form>
</div>
</body>
</html>