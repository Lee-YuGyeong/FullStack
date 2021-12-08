<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//1. 폼 전송되는 삭제할 글 번호와 비밀번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	String pwd=request.getParameter("pwd");
	//2. DB에서 글번호에 해당되는 글 정보를 얻어와서
	GuestBookDao dao=GuestBookDao.getInstance();
	GuestBookDto dto=dao.getData(num);
	//3. 입력한 비밀번호와 글정보에 있는 비밀번호와 일치하는지 확인해서
	boolean isSuccess = false;
	if(pwd.equals(dto.getPwd())){
		//4. 일치하면 실제로 글을 삭제하고 일치하지않으면 삭제하지 않는다.
		isSuccess = dao.delete(num);	
	}
	//응답에 필요한 데이터(모델)을 request영역에 담는다.
	request.setAttribute("isSuccess", isSuccess);
	request.setAttribute("num", num);
	//5. 삭제 성공여부를 응답한다. 

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>guest/delete.jsp</title>
</head>
<body>
<div class="container">
	<h1>알림</h1>
	<c:choose>
		<c:when test="${requestScope.isSuccess }">
			<div>
				삭제하였습니다.
				<a href="list.jsp">목록보기</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				실패하였습니다.
				<a href="detail.jsp?num=${num }">돌아가기</a>
			</div>
		</c:otherwise>
	</c:choose>

</div>
</body>
</html>