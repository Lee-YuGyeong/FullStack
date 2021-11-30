<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<button id="one">눌러보셈</button>
	<button id="two">눌러보셈</button>
	<script>
		/* 
			$( ).on("이벤트명",콜백함수)
			
			[이벤트명]
			click, mousedown, mousemove, mouseover, mouseout,
			focus, blur, keydown, keyup, keypressed, submit...
		*/
		$("#one").on("click",function(){
			console.log("clicked!");
		});
		
		// $().이벤트명(콜백함수);
		$("#two").click(function(){
			console.log("clicked!");
		})
	</script>
</body>
</html>