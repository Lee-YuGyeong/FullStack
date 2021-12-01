<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step06_example5.jsp</title>
</head>
<body>
<div class="container">
	<h1>회원 목록 입니다.</h1>
	<button id="moreBtn">친구 목록 더보기</button>
	<button id="moreBtn2">친구 목록 더보기(json)</button>
	<button id="moreBtn3">친구 목록 더보기(json)</button>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>김구라</td>
				<td>노량진</td>
			</tr>
		</tbody>
	</table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

   	$("#moreBtn").click(function(){
   		$.ajax({
   			url:"more_member.jsp",
   			method:"get",
   			success:function(responseData){
   				$("tbody").append(responseData);
   			}
   		});
   	});

   $("#moreBtn2").click(function(){
	      $.ajax({
	         url:"more_member2.jsp",
	         method:"get",
	         success:function(responseData){
	        	 //responseData => [{num:1, name:"김구라",addr:"노량진"},{},{}]
	        	 $(responseData).each(function(){
	        		 //this는 회원 한명의 정보가 들어있는 object이다.
	        		 console.log(this);
	        		 //td 3를 만들어서
	        		 let td1=$("<td>").text(this.num);
	        		 let td2=$("<td>").text(this.name);
	        		 let td3=$("<td>").text(this.addr);
	        		 //tr에 위에서 만든 td 3개를 추가하고 tbody에 붙인다.
	        		 $("<tr>").append(td1).append(td2).append(td3).appendTo("tbody");
	        	 });
	         }
	      });
	   });
   
   $("#moreBtn3").click(function(){
	      $.ajax({
	         url:"more_member2.jsp",
	         method:"get",
	         success:function(responseData){
	        	 //responseData => [{num:1, name:"김구라",addr:"노량진"},{},{}]
	        	 $(responseData).each(function(){
					let result=`
						<tr>
							<td>\${this.num}</td>
							<td>\${this.name}</td>
							<td>\${this.addr}</td>
						</tr>
					`;
					$("tbody").append(result);
	        	 });
	         }
	      });
	   });
</script>

</body>
</html>