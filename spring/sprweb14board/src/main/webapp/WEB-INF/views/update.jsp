<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="./resources/css/board.css" />
<script type="text/javascript">
	window.onload = function(){
		document.querySelector("#btnUp").onclick = chkUpData;
		
	}
	function chkUpData(){
		//alert("aa");
		//console.log("aa");
		//입력자료 오류검사가 필요하지만 생략...
		if(upfrm.pass.value === ""){
			upfrm.pass.focus();
			alert("비밀번호를 입력하세요");
			return;
		}
		
		if(confirm("정말 수정할까요?")){
			upfrm.submit();
		}
	}
</script>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${msg !=null }">
	<script>
		(function msg(){
			alert("${msg}");
		})();//이름이 없는 함수를 한번 실행
		location.href="list?page=${page}";
		//upfrm.pass.focus();
	</script>
</c:if>
<h2>* 글 수정 *</h2>
<form action="update" method="post" name="upfrm">
<input type="hidden" name="num" value="${data.num }">
<input type="hidden" name="page" value="${page }">
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${data.name }" /></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pass" /></td>
		</tr>
		<tr>
			<td>메일</td>
			<td><input type="text" name="mail" value="${data.mail }" /></td>
		</tr>		
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${data.title }" style="width: 99%"/></td>
		</tr>		
		<tr>
			<td>내용</td> 
			<td>
				<textarea name="cont" style="width: 99%" rows="5">${data.cont }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="button" value="수 정" id="btnUp"  />
				<input type="button" value="목 록" onclick="location.href='list?page=${page}'"  />
			</td>
		</tr>
	</table>

</form>
</body>
</html>