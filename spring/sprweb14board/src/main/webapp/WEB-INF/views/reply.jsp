<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="./resources/css/board.css" type="text/css" />
<script type="text/javascript">
	window.onload = function(){
		document.querySelector("#btnReply").onclick = chkfunc;
	}
	function chkfunc(){
		//alert("c");
		//입력자료 오류 검사
		if(refrm.name.value === ""){
			alert("작성자 이름을 입력하시요");
			refrm.name.focus();
			return;
		}
		//...
		refrm.submit();
	}
</script>
</head>
<body>
<h2>* 댓글 쓰기 *</h2>
<form action="reply" method="post" name="refrm">
	<input type="hidden" name="num" value="${data.num }" />
	<input type="hidden" name="page" value="${page }" />
	<input type="hidden" name="gnum" value="${data.gnum }" />
	<input type="hidden" name="onum" value="${data.onum }" />
	<input type="hidden" name="nested" value="${data.nested }" />
	<input type="hidden" name="bip" value="<%=request.getRemoteAddr() %>" />
	<table border="1">
		 <tr>
            <td>이름</td>
            <td><input type="text" name="name" /></td>
         </tr>
         <tr>
            <td>암호</td>
            <td><input type="text" name="pass" /></td>
         </tr>
         <tr>
            <td>이메일</td>
            <td><input type="email" name="mail" /></td>
         </tr>
         <tr>
            <td>제목</td>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <c:set var="title" value="${data.title }"/>
            <td>
            	<input type="text" name="title" value="[Re]:${fn:substring(title,0,8) }" style="width:99%"/>
            	
            </td>
         </tr>
         <tr>
            <td>글내용</td>
            <td>
               <textarea name="cont" rows="5" style="width:99%"></textarea>
            </td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:center;">
               
               <input type="button" value="작 성" id="btnReply" />&nbsp;&nbsp;
               <input type="button" value="목 록" onclick ="location.href='list?page=${page}'"/>
               
            </td>
         </tr>
	</table>


</form>
</body>
</html>