<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/index.jsp</title>
</head>
<body>
	<h1>인덱스 페이지 입니다.</h1>
	<form action="test/tweet.jsp" method="post">
		<input type="text" name="msg" placeholder="서버에 할말 입력..." />
		<button type="submit">전송</button>
	</form>
	<%
		//로그인된 아이디가 있는지 읽어와보기
		String id=(String)session.getAttribute("id");
	%>
	<%if(id==null){ %>
		<h2>가상의 로그인 폼</h2>
		<form action="test/login.jsp" method="post">
			<input type="text" name="id" placeholder="아이디..."/>
			<input type="password" name="pwd" placeholder="비밀번호..."/>
			<button type="submit">로그인</button>
		</form>
  
	<%}else{ %>
		<p>
			<strong><%=id %></strong>님 로그인중...
			<a href="test/logout.jsp">로그아웃</a>
		</p>
		
	<%} %>
	<ul>
		<li><a href="test/loginform.jsp">로그인 하러가기</a></li>
		<li><a href="private/play.jsp">놀러가기(로그인 필요)</a></li>
		<li><a href="private/study.jsp">공부하러 가기(로그인 필요)</a></li>
	</ul>
   	<a href="test/busan.jsp">부산가기</a>
   	<a href="test/inchon.jsp">인천가기</a>
</body>
</html>