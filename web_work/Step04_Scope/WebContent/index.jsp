<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>인덱스 페이지 입니다.</h1>
	<ul>
		<li><a href="fortune">오늘의 운세</a></li>
		<li><a href="member">회원 한명의 정보 보기</a></li>
		<li><a href="test/fortune.jsp">서블릿을 거치지 않고 바로 요청하면?</a></li>
		<li><a href="test/member.jsp">서블릿을 거치지 않고 바로 요청하면?</a></li>
	</ul>
	<h3>폼을 jsp 페이지에 제출</h3>
	<form action="test/save.jsp" method="post">
		<input type="text" name="nick" placeholder="닉네임 입력..."/>
		<button type="submit">닉네임을 session 영역에 저장하기</button>
	</form>
	
	<h3>폼을  서블릿에 제출</h3>
	<form action="test/save" method="post">
		<input type="text" name="nick" placeholder="닉네임 입력..."/>
		<button type="submit">닉네임을 session 영역에 저장하기</button>
	</form>
	<%
		//session 영역에 "nick" 이라는 키값으로 저장된 문자열이 있는지 읽어와 본다.
		String nick=(String)session.getAttribute("nick");
	%>
	<%if(nick != null){ %>
		<p> 당신의 닉네임은 <strong><%=nick %></strong> 이군요 ^^</p>
	<%} %>
</body>
</html>












