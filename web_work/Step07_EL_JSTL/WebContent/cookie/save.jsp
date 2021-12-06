<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폼전송되는 문자열 읽어오기 
	request.setCharacterEncoding("utf-8");
	String msg=request.getParameter("msg");
	
	String encodedMsg=URLEncoder.encode(msg, "utf-8");
	
		
	//1. 쿠키객체 생성  new Cookie("key", value);
	Cookie cook=new Cookie("savedMsg", encodedMsg);
	//2. 쿠키 유지시간(초단위)
	cook.setMaxAge(60);
	//3. HttpServletResponse 객체에 담는다.
	response.addCookie(cook);
	//4. 응답할때 쿠키가 자동으로 응답되고 클라이언트의 웹브라우저에 저장이 된다.

	
	/*
		쿠키로 저장할 수 있는 문자의 가지수는 64가지만 가능하다
		영문자 대소문자 + 숫자 + 슬래시 + 더하기만 가능하다
		따라서 그 외의 문자는 약속된 기호로 변환을 해서 저장해야한다.
		URLEncoder를 이용해서 인코딩을 해주는 이유이다.
	*/
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cookie/save.jsp</title>
</head>
<body>
	<p>웹브라우저에 savedMsg 라는 키값으로  저장했습니다.</p>
	<p>인코딩된 결과 : <strong><%=encodedMsg %></strong></p>
	<a href="read.jsp">쿠기에 저장된 내용 읽어오기</a>
</body>
</html>