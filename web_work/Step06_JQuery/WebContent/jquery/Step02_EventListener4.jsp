<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step02_EventListener4.jsp</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
   <p>메세지를 입력하고 Enter 를 입력해 보세요</p>
   <input id="inputMsg" type="text" placeholder="메세지 입력..."/>
   <ul id="msgList">
      <li>하나</li>
      <li>두울</li>
   </ul>
   <script>
      /*
         input 요소에 keyup 이벤트가 일어나고 그 키가 만일 Enter 라면
         li 요소를 동적으로 만들어서 innerText 로 input 요소에 입력한 문자열을 읽어와서 넣어주고
         li 를 id 가 msgList 인 곳에 추가해 보세요.
         
         - hint 
         
         $("<li>").text("xxx").appendTo("#msgList");
      
         $( ).on("keyup", function(e){
            let code = e.keyCode;
            
         });
      */
      
      $("#inputMsg").on("keyup", function(e){
         //만일 엔터를 쳤다면
         if(e.keyCode == 13){
            //입력한 value 값을 읽어와서 
            let msg=$(this).val();
            // li 요소를 만들어서 innerText 를 출력하고 원하는 곳에 추가하기 
            $("<li>").text(msg).appendTo("#msgList");
            //입력한 내용 지우기 
            $(this).val("");
         }
      });
   </script>
</body>
</html>






