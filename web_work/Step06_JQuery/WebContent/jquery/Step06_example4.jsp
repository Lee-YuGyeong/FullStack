<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step06_example4.jsp</title>
</head>
<body>
<div class="container">
   <h1>오늘의 이슈</h1>
   <button id="moreBtn">이슈 더 받아오기(html)</button>
   <button id="moreBtn2">이슈 더 받아오기2(json)</button>
   <button id="moreBtn3">이슈 더 받아오기3(json)</button>
   <p>이슈1</p>
   <p>이슈2</p>
   <p>어쩌구 저쩌구...</p>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
   $("#moreBtn").click(function(){
      $.ajax({
         url:"more_issue.jsp",
         method:"get",
         success:function(responseData){
            //$(".container").text(responseData);
        	//$(".container").html(responseData);
        	 $(".container").append(responseData);
         }
      });
   });

   $("#moreBtn2").click(function(){
      $.ajax({
         url:"more_issue2.jsp",
         method:"get",
         success:function(responseData){
        	 //responseData => ["xxx","xxx","xxx"] 형식의 배열이다.
			console.log(responseData);
        	 //반복문 돌면서
			for(let i=0;i<responseData.length;i++){
				//동적으로 p요소를 만들고 innerText를 출력하고 .container에 추가하기
				$("<p>").text(responseData[i]).appendTo(".container");
			}
         }
      });
   });
   
   $("#moreBtn3").click(function(){
	      $.ajax({
	         url:"more_issue3.jsp",
	         method:"get",
	         success:function(responseData){
	        	 //responseData => ["xxx","xxx","xxx"] 형식의 배열이다.
				console.log(responseData);
	        	 //반복문 돌면서
				for(let i=0;i<responseData.length;i++){
					//동적으로 p요소를 만들고 innerText를 출력하고 .container에 추가하기
					$("<p>").text(responseData[i]).appendTo(".container");
				}
	         }
	      });
	   });
</script>

</body>
</html>








