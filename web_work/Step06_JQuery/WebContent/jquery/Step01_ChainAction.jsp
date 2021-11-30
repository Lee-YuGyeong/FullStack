<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Step01_ChainAction.jsp</title>
<!-- jquery 로딩 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<p id="one">p요소 입니다.</p>
	<p id="two">p요소 입니다.</p>
	<script>
		/*
			id 가 one 인 요소의
			
			1. innerText 를  안녕하세요
			2. 글자색을 red 
			3. 배경색을 yellow 
			
			로 변경하기 
		*/
		let p1 = document.querySelector("#one");
		p1.innerText="안녕하세요";
		p1.style.color="red";
		p1.style.backgroundColor="yellow";
		/*
			id 가 two 인 요소의
			
			1. innerText 를  안녕하세요
			2. 글자색을 red 
			3. 배경색을 yellow 
			
			로 jquery 를 이용해서 변경하기 
		*/
		$("#two").text("안녕하세요").css("color","red").css("background-color","yellow");
		
	</script>
</body>
</html>






