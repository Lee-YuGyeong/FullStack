<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//1. 수정할 글번호와 입력한 비밀번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	String pwd=request.getParameter("pwd");
	
	//2. DB에서 해당글의 정보를 얻어온다.
	GuestBookDto dto=GuestBookDao.getInstance().getData(num);
	//3. 비밀번호가 일치하는지 확인한다.
	boolean isPwdValid=pwd.equals(dto.getPwd());
	//4. 일치하면 수정할 글 정보를 폼에 출력해주고
	
	//5. 일치하지 않는다면 비밀번호가 일치하지 않는다고 알려준다.
	
	//6. 응답에 필요한 데이터(모델)을 request영역에 담는다.
	request.setAttribute("dto", dto);
	request.setAttribute("isPwdValid",isPwdValid);
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/updateform.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${isPwdValid }">
		<h1>글 수정 폼입니다.</h1>
		<form action="update.jsp" method="post">
			<input type="hidden" name="num" value="${dto.num }"/>
			<div>
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer" value="${dto.writer }" />
			</div>
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="${dto.title }" />
			</div>
			<div>
				<label for="content">내용</label>
				<textarea name="content" id="content" rows="10" cols="30">${dto.content }</textarea> 
			</div>
			<button type="submit">수정확인</button>
			<button type="reset">취소</button>
			
		</form>
	</c:when>
	<c:otherwise>
		<h1>알림</h1>
		<p>
			비밀번호가 일치하지 않아요!
			<a href="detail.jsp?num=${param.num }">글 자세히 보기로 돌아가기</a>
		</p>
	</c:otherwise>
</c:choose>
	
	
</body>
</html>