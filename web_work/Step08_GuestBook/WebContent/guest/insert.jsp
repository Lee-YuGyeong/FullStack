<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//한글 인코딩 설정은 EncodingFilter에서 처리되기 때문에 필요없다.
	
	//post 방식으로 form 전송되는 파라미터를 추출해서
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	//GuestBookDto에 담아서
	GuestBookDto dto=new GuestBookDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	dto.setPwd(pwd);
	//DB에 저장하고
	boolean isSuccess=GuestBookDao.getInstance().insert(dto);
	//응답에 필요한 데이터(Model)을 request 영역에 담기
	request.setAttribute("isSuccess", isSuccess);
	//응답한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/insert.jsp</title>
</head>
<body>
<div class="container">
	<h1>알림</h1>
	<c:choose>
		<c:when test="${requestScope.isSuccess }">
			<div>
				새글을 저장했습니다.
				<a href="list.jsp">목록보기</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				새글 등록이 실패되었습니다.
				<a href="insertform.jsp">다시작성</a>
			</div>
		</c:otherwise>
	</c:choose>
	
	
</div>





</body>
</html>