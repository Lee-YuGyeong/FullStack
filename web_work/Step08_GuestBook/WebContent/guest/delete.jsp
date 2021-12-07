<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 폼 전송되는 삭제할 글 번호와 비밀번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	String pwd=request.getParameter("pwd");
	//2. DB에서 글번호에 해당되는 글 정보를 얻어와서
	GuestBookDto dto=GuestBookDao.getInstance().getData(num);
	//3. 입력한 비밀번호와 글정보에 있는 비밀번호와 일치하는지 확인해서
	boolean isSuccess = false;
	if(pwd.equals(dto.getPwd())){
		isSuccess = GuestBookDao.getInstance().delete(num);
	}else{
		
	}
	//4. 일치하면 실제로 글을 삭제하고 일치하지않으면 삭제하지 않는다.
	
	//5. 삭제 성공여부를 응답한다. 
	if(isSuccess){
		
	}else{
		
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>guest/delete.jsp</title>
</head>
<body>

</body>
</html>