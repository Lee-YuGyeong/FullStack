<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	
	//검색 키워드가 GET 방식 파라미터로 넘어 올 수도 있고 안넘어 올 수도 있다.
	String keyword=request.getParameter("keyword");
	List<GuestBookDto> list=null;
	if(keyword==null){//만일 키워드가 넘어오지 않으면
		//키워드에 빈 문자열을 넣어준다
		keyword="";
		//전체 글목록을 얻어오고
	}else{//키워드가 넘어온다면
		//키워드에 부합하는 글 목록을 얻어온다.
		
	}
	list=GuestBookDao.getInstance().getListKeyword(keyword);
	//글 목록을 얻어오기
	//List<GuestBookDto> list=GuestBookDao.getInstance().getList(dto);
	//EL 을 이용해서 글목록을 추출할수 있도록 request 영역에 담아둔다. 
	request.setAttribute("list", list);
	request.setAttribute("keyword", keyword);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<a href="insertform.jsp">새글 작성</a>
	<h1>방명록 글 목록입니다.</h1>
	<form action="list2.jsp" method="get">
		<div class="input-group">
			<input class="form-control" type="text" name="keyword" placeholder="검색어 입력..." value="${keyword }" />
			<button class="btn btn-outline-secondary" type="submit">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  				<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
				</svg>
			</button>
		</div>
	</form>
	<table class="table table-striped">
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