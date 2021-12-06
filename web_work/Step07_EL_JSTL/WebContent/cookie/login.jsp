<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//폼 전송되는 파라미터를 읽어온다.
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//체크박스를 체크했는지 확인(체크하지 않았으면 null)이다.
	String isSave=request.getParameter("isSave");
	
	/*
		만일 체크박스를 체크했다면
		savedId 라는 키값으로 아이디, savedPwd 라는 키값으로 비밀번호를
		쿠키에 저장이 되도록 프로그래밍 해보세요.
		쿠키 유지시간은 60초로 설정하면됩니다.
		
		만일 체크박스를 체크하지않았다면
		쿠키를 삭제하도록 해보세요.
		삭제하는 방법은 쿠기 유지시간을 0초로 설정해서 동일한 쿠키를 응답하면됩니다.
	*/
	Cookie cook1=new Cookie("savedId", id);
	Cookie cook2=new Cookie("savedPwd", pwd);
	//체크 박스를 체크한 경우 
	if(isSave != null){ 
		cook1.setMaxAge(60);
		cook2.setMaxAge(60);
	}else{//체크하지 않은 경우    
		cook1.setMaxAge(0);
		cook2.setMaxAge(0);
	}
	response.addCookie(cook1);
	response.addCookie(cook2);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cookie/login.jsp</title>
</head>
<body>
	<p><%=id %>님 로그인되었습니다.</p>	
	<a href="loginform.jsp">로그인폼으로 돌아가서 확인해보기</a>
	
</body>
</html>