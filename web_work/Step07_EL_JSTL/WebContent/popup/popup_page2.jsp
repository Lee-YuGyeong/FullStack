<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup/popup_page2.jsp</title>
<style>
	body{
		background-color:yellow;
	}
</style>
</head>
<body>
	<h3>팝업된 페이지 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error nihil impedit quas et optio veniam debitis nam numquam voluptatum quisquam voluptatem sed aliquam libero in molestiae ab ducimus neque modi?</p>
	<form action="close.jsp" method="post">
		<label>
			<input type="checkbox" name="canPopup" value="no" />
			1분동안 팝업 띄우지 않기
		</label>
		<button type="submit">닫기</button>
	</form>
	
	
	
	
</body>
</html>