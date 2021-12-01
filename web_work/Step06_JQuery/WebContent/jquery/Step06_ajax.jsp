<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step06_ajax.jsp</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
   <a href="${pageContext.request.contextPath}/index.jsp">index.jsp 페이지 요청하기</a>
   <br />
   <form action="send.jsp" method="post">
      <input type="text" name="msg" placeholder="전송할 메세지 입력..."/>
      <button type="submit">전송</button>
   </form>
   <br />
   <button id="requestBtn">요청하기</button>
   <br />
   
   <input type="text" id="inputMsg" placeholder="전송할 메세지 입력..."/>
   <button id="sendBtn">ajax 전송</button>
   
   <script>
      $("#requestBtn").on("click", function(){
         $.ajax({
            url:"${pageContext.request.contextPath}/index.jsp",
            method:"get",
            success:function(responseData){
               console.log(responseData);
            }
         });
      });
      /*
      	ajax 요청하면서 파라미터를 전달하고 싶으면
      	query 문자열을 구성을해서 data라는 방에 전달하면된다.
      	[query 문자열]
      	
      	파라미터명=값&파라미터명2=값2...
      
      */
      $("#sendBtn").on("click", function(){
         //입력한 문자열 읽어오기
         let msg=$("#inputMsg").val();
         //send.jsp 페이지에 post 방식으로 ajax 전송하기
         $.ajax({
            url:"send.jsp",
            method:"post",
            data:"msg="+msg,
            success:function(responseData){
               console.log(responseData);
            }
         });
      });
   </script>
</body>
</html>








