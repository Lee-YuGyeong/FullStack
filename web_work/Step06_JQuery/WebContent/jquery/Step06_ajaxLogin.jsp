<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step06_ajaxLogin.jsp</title>
<style>
   #loginForm, #info{
      display: none;
   }
</style>
</head>
<body>
   <h1>ajax 로그인 예제</h1>
   <%
      String id=(String)session.getAttribute("id");
   %>
   <form action="login.jsp" method="post" id="loginForm">
      <input type="text" name="id" placeholder="아이디 입력..."/>
      <input type="text" name="pwd" placeholder="비밀번호 입력..."/>
      <button type="submit">로그인</button>
   </form>
   
   <p id="info">
      <strong><%=id %></strong>님 로그인중...
      <a href="logout.jsp">로그아웃</a>   
   </p>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
   let isLogin=<%= id==null ? false:true %>;
   
   if(isLogin){
      $("#info").show();
   }else{
      $("#loginForm").show();
   }
   
   //폼에 submit 이벤트가 일어 났을때 호출되는 함수 등록
   $("#loginForm").on("submit", function(){
      //폼에 입력한 내용을 한줄의 문자열(query 문자열) 로 만들기 
      let data=$(this).serialize(); // id=xxx&pwd=xxx 
      console.log(data);
      //폼에 입력한 내용을 ajax 요청을 통해서 서버에 전송한다.
      $.ajax({
         url:"login.jsp",
         method:"post",
         data:data,
         success:function(responseData){
            console.log(responseData);
            /*
            	contentType="application/json" 으로 서버에서 응답하면 jquery 가
            	JSON 문자열을 알아서 javascript object로 변환해서 함수에 전달해주기 때문에 
            	JSON.parse()는 필요없다.
            */
            //let result=JSON.parse(responseData);
            if(responseData.isSuccess){
               alert("로그인 되었습니다.");
               $("#loginForm").hide();
               $("#info").show();
               //로그인된 아이디 출력하기
               $("#info strong").text(responseData.id);
            }else{
               alert("아이디 혹은 비밀번호가 틀려요");
            }
         }
      });
      return false; //폼 제출을 막아준다. 
   });
</script>
</body>
</html>


