<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step03_Effect.jsp</title>
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
	<div class="box">div1</div>
	<div class="box">div2</div>
	<div class="box">div3</div>
	<div class="box">div4</div>
	<div class="box">div5</div>
	<script>
		//div를 클릭했을때 클릭한 div를 숨기기
		$(".box").on("click",function(){
			//$(this).css("display","none");
			
			//$(this).hide();
			
			//$(this).hide(1000);
			
			//$(this).hide(function(){
			//	alert("뿅");
			//});
			
			//$(this).hide(1000,function(){
			//	alert("뿅~")
			//});
			$(this).hide({
				duration:1000,
				complete:function(){
					alert("뿅");
				}
			});
		});
		
	</script>
</body>
</html>