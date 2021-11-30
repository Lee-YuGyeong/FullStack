<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step02_EventListener2.jsp</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	.box{
		width:100px;
		height:100px;
		border:1px solid red;
		float: left;
	}
</style>
</head>
<body>
	<div class="box">box1</div>
	<div class="box">box2</div>
	<div class="box">box3</div>
	<div class="box">box4</div>
	<div class="box">box5</div>
	<script>
		/*
			mousedown 이벤트가 일어난 div에
			1. 배경색을 노란색
			2. innerText를 "mousedown!"
			
			으로 변경해보세요.
		*/
		$(".box").on("mousedown",function(){
			$(this).css("background-color","yellow").text("mousedown!");
		});
	</script>
</body>
</html>