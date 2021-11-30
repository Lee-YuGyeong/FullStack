<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/hello.jsp</title>
<!-- jquery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<p>p1</p>
	<p class="my-class">p2</p>
	<p class="my-class">p3</p>
	<p class="my-class">p4</p>
	<p class="my-class">p5</p>
	<button id="changeBtn">바꾸기</button>
	<button id="changeBtn2">바꾸기2</button>
	<input type="text" id="two" />
	<select id="three">
		<option value="apple">사과</option>
		<option value="orange">오렌지</option>
		<option value="banana">바나나</option>
	</select>
	<script>
		//바꾸기 버튼을 눌렀을때 모든 p요소의 글자색을 빨간색으로 바꿔보세요.
		document.querySelector("#changeBtn").addEventListener("click",function(){
			//모든 p 요소의 참조값을 배열에 담아오기
			let ps=document.querySelectorAll("p");
			//반복문 돌면서
			for(let i=0;i<ps.length;i++){
				//각각의 p요소 글자색을 red로 바꾸기
				ps[i].style.color="red";
			}
		});
		$("#changeBtn2").on("click",function(){
			$("p").css("color","red");	
		});
		
	</script>
</body>
</html>