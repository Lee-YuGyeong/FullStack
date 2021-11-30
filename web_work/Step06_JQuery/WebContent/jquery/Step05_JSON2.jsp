<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step05_JSON2.jsp</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
   <h1>친구 목록입니다.</h1>
   <ul id="one">
   
   </ul>
   <h1>친구 목록입니다2.</h1>
   <ul id="two">
   
   </ul>
   <script>
      let names=["김구라", "해골", "원숭이"];
      
      for(let i=0; i<names.length; i++){
         let tmp=names[i];
         $("<li>").text(tmp).appendTo("#one");
      }
      //친구목록이 JSON 문자열 형식으로 있다면
      let data='["주뎅이", "덩어리", "돼지"]';
      //JSON 문자열을 파싱해서 실제 배열로 만든다. 
      let result=JSON.parse(data);
      
      for(let i=0; i<result.length; i++){
         let tmp=result[i];
         $("<li>").text(tmp).appendTo("#two");
      }
   </script>
</body>
</html>




