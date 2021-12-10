<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//수정할 글 정보를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	//수정할 글 정보를 GuestBookDto에 담는다
	GuestBookDto dto=new GuestBookDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	//GuestBookDao 객체를 이용해서 수정한다.
	GuestBookDao.getInstance().update(dto);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/update.jsp</title>
</head>
<body>
	<script>
		alert("수정했습니다.");
		//javascript 를 활용해서 페이지 이동 시키기
		location.href="detail.jsp?num=<%=num%>";
	</script>
</body>
</html>