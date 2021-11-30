<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//post 방식 전송했을때 한글 깨지지 않도록
	request.setCharacterEncoding("utf-8");
	//nick 이라는 파라미터명으로 전달된 파라미터 추출
	String nick=request.getParameter("nick");
	//session 영역에 "nick" 이라는 키값으로 추출한 내용을 담기
	session.setAttribute("nick", nick);
	//session 영역에 저장한 데이터 유지시간 지정하기
	session.setMaxInactiveInterval(60); //60초동안 어떤 요청도 하지 않으면 자동 삭제된다.(설정하지 않으면 30분)
	/*
		session scope (세션 영역) 에 담은 데이터가 삭제 되는 경우는
		1. 새로운 요청을 하지 않고 30분이 경과 했을때 (기본시간)
		2. 웹브라우저를 닫았을때
		3. HttpSession 객체의 메소드를 이용해서 강제로 삭제 했을때
	*/
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/save.jsp</title>
</head>
<body>
	<p> <strong><%=nick %></strong> 이라는 닉네임을 기억 하겠습니다.</p>
	<p>60초 동안 아무런 요청을 하지 않거나 웹브라우저를 닫으면 자동 삭제 됩니다.</p>
	<a href="../index.jsp">인덱스로 가기</a>
</body>
</html>




