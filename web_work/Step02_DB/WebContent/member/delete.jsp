<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//GET 방식 파라미터로 전달되는 삭제할 회원의 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//DB에서 해당 회원을 삭제하고
	boolean isSuccess=MemberDao.getInstance().delete(num);
	//응답하기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/delete.jsp</title>
</head>
<body>
	<%if(isSuccess){ %>
		<script>
			alert("<%=num%>번 회원의 정보를 삭제했습니다.");
			location.href="list.jsp";
		</script>
	<%}else{ %>
		<script>
			alert("회원정보 삭제 실패!");
			location.href="list.jsp";
		</script>
	<%} %>
</body>
</html>