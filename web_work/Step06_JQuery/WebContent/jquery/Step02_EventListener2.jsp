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
		width:500px;
		height:500px;
		border:1px solid red;
	
	}
</style>
</head>
<body>
	<div class="box"></div>
	<script>
		$(".box").on("mousemove",function(e){
			//e는 mouse event 객체이다.
			console.log(e);
			let x = e.offsetX;
			let y = e.offsetY;
			//이벤트가 일어난 바로 그 요소 선택 $(this)
			$(this).text("x:"+x+" y:"+y);
		});
	</script>
</body>
</html>