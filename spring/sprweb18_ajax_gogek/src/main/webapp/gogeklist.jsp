<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(document).ready(function(){
	$("#gogek").click(function(){
		$("#showData").empty();
		$.ajax({
			type:"get",
			url:"gogeklist",
			dataType:"json",
			success:function(data){
				let str = "<table><thead>"+
								"<td>번호</td>"+
								"<td>이름</td>"+
								"<td>전화번호</td>"+
								"<td>주민등록번호</td>"+
								"<td>damsano</td>"+
							"</thead>";
				let datas = data.datas;
				$(datas).each(function(idx,tmp){
					console.log(tmp.gogek_no);
					str += "<tr>";
					str += "<td>"+ tmp.gogek_no+"</td><td>"+ tmp.gogek_name+"</td><td>"+ tmp.gogek_tel+"</td><td>"+ tmp.gogek_jumin+"</td><td>"+ tmp.gogek_damsano+"</td>";
					str += "</tr>";
				});
				str += "</table>";
				$("#showData").html(str);
			},
			error:function(){
				$("#showData").html("에러발생");
			}
		});
	});
	
});
</script>
<title>Insert title here</title>
</head>
<body>
<button id="gogek">고객보기</button>

<div id="showData"></div>


</body>
</html>