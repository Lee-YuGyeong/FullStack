<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnList").onclick = function(){
		location.href = "list";
	}
}
</script>
</head>
<body>
** 상세보기 **<p/>
글 번호 : ${board.num }<br>
작성자 : ${board.author }<br>
글 제목 : ${board.title }<br>
글 내용: ${board.content }<br><br>
글 작성일 : ${board.bwrite }<br>
글 조회수 : ${board.readcnt }<br><br>
<input type="button" id="btnList" value="돌아가기">
</body>
</html>