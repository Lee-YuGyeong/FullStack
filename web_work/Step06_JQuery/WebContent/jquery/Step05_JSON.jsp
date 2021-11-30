<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step05_JSON.jsp</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
   <input id="inputData" type="text" placeholder="JSON 입력..."/>
   <button id="parseBtn">파싱</button>
   <script>
      $("#parseBtn").on("click", function(){
         let jsonStr=$("#inputData").val();
         console.log(jsonStr);
         //JSON 형식의 문자열은 JSON.parse() 함수를 이용해서 실제 javascript 객체로 만들수 있다.
         let result=JSON.parse(jsonStr);
         console.log(result);
      });
   </script>
</body>
</html>




