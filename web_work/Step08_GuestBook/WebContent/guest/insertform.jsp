<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/insertform.jsp</title>
</head>
<body>
<div class="container">
	<h1>방명록에 글을 남겨 주세요</h1>
	<form action="insert.jsp" method="post" id="insertForm">
	   <div>
	      <label for="writer">작성자</label>
	      <input type="text" name="writer" id="writer"/>
	   </div>
	   <div>
	      <label for="title">제목</label>
	      <input type="text" name="title" id="title"/>
	   </div>
	   <div>
	      <label for="content">글내용</label>
	      <textarea name="content" id="content" cols="30" rows="10"></textarea>
	   </div>
	   <div>
	      <label for="pwd">비밀번호</label>
	      <input type="password" name="pwd" id="pwd"/>
	   </div>
	   <div>
	      <label for="pwd2">비밀번호 확인</label>
	      <input type="password" name="pwd2" id="pwd2"/>
	   </div>
	   <button type="submit">저장하기</button>
	</form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$("#insertForm").on("submit",function(){
		let pwd=$("#pwd").val();
		let pwd2=$("#pwd2").val();
		if(pwd!=pwd2){
			alert("비밀번호를 확인하세요");
			//폼 전송 막기
			return false; // jqeury를 사용할때만 가능
		}
	});
</script>
</body>
</html>





