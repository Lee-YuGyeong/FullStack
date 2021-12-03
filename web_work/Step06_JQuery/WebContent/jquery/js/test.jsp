<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<button id="printBtn">출력하기</button>
	<ul id="nameList">
	
	
	</ul>
<script>
	let names=["김구라","해골","원숭이"];
	

	$("#printBtn").on("click",function(){
		for(let i=0;i<names.length;i++){
			$("<li>").text(names[i]).appendTo($("#nameList"));
		}
	});
	

</script>
</body>
</html>