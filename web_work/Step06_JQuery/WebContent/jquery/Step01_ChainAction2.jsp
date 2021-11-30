<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Step01_ChainAction2.jsp</title>
<!-- jquery 로딩 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
   <div>div1</div>
   <div>div2</div>
   <div id="one">div3</div>
   <div>div4</div>
   <div>div5</div>
   <input type="text" id="two"/>
   <input type="text" />
   <script>
   		//chain 형식으로 여러 동작을 한줄의 javascript로 할수 있다.
   		$("div").css("color","red").text("김구라");
   		
   		//id가 one인 요소의 innerText를 읽어오는 동작이기 때문에 chain 형식의 동작은 불가능하다.
   		let a=$("#one").text();
   		//id가 one인 요소에 innerText를 넣어주는 동작이기 때문에 chain 형식의 동작 가능하다.
   		$("#one").text();
   		
   		//id가 two 인 요소의 value 값을 읽어오는 동작이기 때문에 chain 형식의 동작은 불가능하다.
   		let b=$("two").val();
   		//id가 two 인 요소에 value 값을 넣어주는 동작이기 때문에 chain 형식의 동작은 가능하다.
   		$("two").val("안녕하세요").css();
   </script>
</body>
</html>




