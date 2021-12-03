<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step03_Effect2.jsp</title>
<style>
	.box{
		width:100px;
		height:100px;
		border:1px solid red;
		background-color: yellow;
		cursor:pointer;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<button id="hideBtn">숨기기</button>
	<button id="showBtn">보이기</button>
	<button id="toggleBtn">토글</button>
	<div class="box">div1</div>
	
	<script>
		$("#hideBtn").on("click",function(){
			//$(".box").hide(1000);
			//$(".box").fadeOut(1000); 
			$(".box").slideUp(1000);
		});
		
		$("#showBtn").on("click",function(){
			//$(".box").show(1000);
			//$(".box").fadeIn(1000);
			$(".box").slideDown(1000);
		});
	
		$("#toggleBtn").on("click",function(){
			//$(".box").toggle(1000);
			//$(".box").fadeToggle(1000)
			$(".box").slideToggle(1000);
		});
	</script>
</body>
</html>