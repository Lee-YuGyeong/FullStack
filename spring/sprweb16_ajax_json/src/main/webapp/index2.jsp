<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnOk").click(function(){
		//alert("aa");
		$("#showData").html("");
		$.ajax({
			type:"get",
			url:"list",
			data:{"name":"tom"},
			dataType:"json",
			success:function(data){
				//alert(data);
				let str = data.name + "<br>";
				str += data.skills[0] + " " ;
				str += data.skills[1];
				$("#showData").html(str);
			},
			error:function(){
				$("#showData").text("에러 발생!");
			}
		});
	});
	
	$("#btnOk2").click(function(){
		//alert("bb");
		$("#showData").html("");
		
		$.ajax({
			type:"get",
			url:"list2",
			dataType:"json",
			success:function(data){
				let str = "<table border=1>";
				let list = data.datas;
				$(list).each(function(idx, objArr){
					str+= "<tr>";
					str+= "<td>"+objArr.name + "</td>";
					str+= "<td>"+objArr.age + "</td>";
					str+= "</tr>";
				});
				str += "</table>"
				
				$("#showData").html(str);
			},
			error:function(){
				$("#showData").text("에러 발생!");
			}
		});
	});
});

</script>
</head>
<body>
<h1>Ajax 처리 : json</h1>
뭔가를 입력 : <input type="text" size="80" />
<br /><br />
<a href="list?name=james">json 처리 : 동기방식</a><br />
<button id="btnOk">한 개의 자료 읽기</button><br />
<button id="btnOk2">여러 개의 자료 읽기</button><br />
<br />
읽혀진 json 자료 출력 : 
<div id="showData"></div>
</body>
</html>