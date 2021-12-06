<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		클라이언트의 요청과 함께 쿠키 정보도 같이 넘어온다.
		넘어온 쿠키 정보는 HttpServletRequest객체에서 읽어올수있다.
		
	*/
	
	Cookie[] cooks=request.getCookies();
	//읽어온 문자열을 저장할 변수를 바깥영역에 미리 선언하기
	String savedMsg=null;
	
	//만일 쿠기가 있다면
	if(cooks != null){
		//반복문 돌면서 쿠키 객체를 하나씩 참조
		for(Cookie tmp:cooks){
			//쿠기의 키값을 읽어온다.
			String key=tmp.getName();
			if(key.equals("savedMsg")){ //만일 우리가 찾는 키값이라면
				//해당 키값으로 저장된 value를 읽어온다.
				savedMsg=tmp.getValue();
			}
		}
	}
	
	String decodedMsg=null;
	if(savedMsg!=null){
		decodedMsg=URLDecoder.decode(savedMsg,"utf-8");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie/read.jsp</title>
</head>
<body>
	<p>savedMsg 라는 키값으로 저장된 문자열 : <%=savedMsg %></p>
	<p>디코딩된 문자열 : <%=decodedMsg %></p>
	<p>saveMsg 라는 키값으로 저장된 문자열 EL로 읽어오기 : ${cookie.savedMsg.value }</p>
</body>
</html>