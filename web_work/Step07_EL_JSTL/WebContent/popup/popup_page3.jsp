<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup/popup_page3.jsp</title>
<style>
	body{
		background-color:yellow;
	}
</style>
</head>
<body>
	<h3>팝업된 페이지 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error nihil impedit quas et optio veniam debitis nam numquam voluptatum quisquam voluptatem sed aliquam libero in molestiae ab ducimus neque modi?</p>
	<input type="text" id="inputMsg" placeholder="부모창에 전달할 메세지 입력..."/>
	<button id="sendBtn">전달</button>
	
	<script>
	document.querySelector("#sendBtn").addEventListener("click",function(){
		//입력한 문자열을 읽어와서
		let msg=document.querySelector("#inputMsg").value;
		//부모창에 있는 getMessage() 함수를 호출하면서 문자열을 전달한다.
		window.opener.getMessage(msg);
		//창닫기
		self.close();
	});
	
	
	</script>
	
</body>
</html>