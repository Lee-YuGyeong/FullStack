<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/insform.jsp</title>
<link rel="stylesheet" type="text/css" href="./resources/css/board.css" />
<script type="text/javascript">
   window.onload=function(){
      let btnIns = document.querySelector("#btnIns");
      btnIns.addEventListener("click",checkData);
   }
   function checkData(){
      //alert("Success");
      //입력 자료 오류 검사
      if(frm.name.value === ""){
    	  alert("작성자를 입력하시오");
    	  frm.name.focus();
    	  return;
      }
      
      if(frm.pass.value === ""){
    	  alert("비밀번호를 입력하시오");
    	  frm.name.focus();
    	  return;
      }
      
      frm.submit();
   }
</script>
</head>
<body>
   <h2>* 글쓰기 *</h2>
   <form action="insert" method="post" name="frm">
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
            <td><input type="mail" name="mail" /></td>
         </tr>
         <tr>
            <td>글제목</td>
            <td><input type="text" name="title" style="width:99%"/></td>
         </tr>
         <tr>
            <td>글내용</td>
            <td>
               <textarea name="cont" rows="5" style="width:99%"></textarea>
            </td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:center;">
               <input type="hidden" name="bip" value="<%=request.getRemoteAddr() %>"/>
               <input type="button" value="등 록" id="btnIns" />&nbsp;&nbsp;
               <input type="button" value="목 록" onclick ="location.href='list?page=1'"/>
               
            </td>
         </tr>
      </table>

   </form>
</body>
</html>