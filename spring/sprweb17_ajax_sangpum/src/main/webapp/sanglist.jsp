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
	$("#btnShow").click(function(){
		$("#showData").empty();
		$.ajax({
			type:"get",
			url:"sangpum",
			dataType:"json",
			success:function(sangpumDatas){
				//alert(sangpumDatas);
				let str = "<table border = '1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
				let datas = sangpumDatas.datas;
				$(datas).each(function(idx,objArr){
					str += "<tr>";
					str += "<td>" + objArr.code + "</td>";
					str += "<td>" + objArr["sang"] + "</td>";
					str += "<td>" + objArr["su"] + "</td>";
					str += "<td>" + objArr["dan"] + "</td>";
					str += "</tr>";
				});
				str += "</table>";
				
				$("#showData").html(str);
			},
			error:function(){
				$("#showData").text("에러 발생");
			}
		});
	});
});
</script>
</head>
<body>
<h2>상품 관련 페이지</h2>
이런 상품 저런 상품 
<hr />
<button id="btnShow">DB에 있는 상품 보여줘</button>
<br />
<div id="showData">...</div>
<hr />
바닥글 작성자 : 홍길동
</body>
</html>