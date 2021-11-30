<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step06_ajaxLogin.jsp</title>
</head>
<body>
<h1>ajax 로그인 예제</h1>
<%
	String id=(String)session.getAttribute("id");
%>
<%if(id==null){ %>
	<form action="login.jsp" method="post" id="loginForm">
		<input type="text" name="id" placeholder="아이디 입력..." />
		<input type="text" name="pwd" placeholder="비밀번호 입력..." />
		<button type="submit">로그인</button>
	</form>
<%}else{ %>
	<p id="info">
		<strong><%=id %></strong>님 로그인 중...
		<a href="logout.jsp">로그아웃</a>
	</p>
<%} %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	//폼에 submit 이벤트가 일어났을때 호출되는 함수등록
	$("#loginForm").on("submit",function(){
		//폼에 입력한 내용을 한줄의 문자열로 만들기
		let data=$(this).serialize();
		console.log(data);
		//폼에 입력한 내용을 ajax 요청을 통해서 서버에 전송한다.
		$.ajax({
			url:"login.jsp",
			method:"post",
			data:data,
			success:function(responseData){
				console.log(responseData);
				let result=JSON.parse(responseData);
				if(result.isSuccess){
					alert("로그인 되었습니다.");
				}else{
					alert("아이디 혹은 비밀번호가 틀려요");
				}
				
			}
		});
		return false; // 폼 제출을 막아준다.
	});
</script>
</body>
</html>