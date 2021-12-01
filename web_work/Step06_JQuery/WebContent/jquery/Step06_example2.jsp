<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step06_example2.jsp</title>
</head>
<body>
<div class="container">
   <h1>회원 가입 폼 입니다.</h1>
   <form action="signup.jsp" method="post" id="signupForm">
      <div>
         <label for="id">아이디</label>
         <input type="text" name="id" id="id"/>
         <div id="feedbackId"></div>
      </div>
      <div>
         <label for="pwd">비밀번호</label>
         <input type="password" name="pwd" id="pwd"/>
         <div id="feedbackPwd"></div>
      </div>
      <button type="submit">가입</button>
   </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
   //아이디의 유효성 여부
   let isIdValid=false;
   //비밀번호의 유효성 여부
   let isPwdValid=false;

   $("#id").on("input", function(){
      //입력한 아이디를 읽어와서 
      let inputId=$("#id").val();
      //ajax 요청으로 서버에 보내서 사용가능한지 응답 받는다.
      $.ajax({
         url:"checkid.jsp",
         method:"get",
         data:"inputId="+inputId,
         success:function(responseData){
            // responseData => {canUse:true} or {canUse:false}
            if(responseData.canUse){//사용가능한 아이디
               $("#feedbackId").text("사용 가능한 아이디 입니다").css("color", "green");
               isIdValid=true;
            }else{//사용 불가능한 아이디
               $("#feedbackId").text("사용 불 가능한 아이디 입니다").css("color", "red");
               isIdValid=false;
            }
         }
      });
      return false; //폼 제출 막기
   });
   
   //비밀번호 입력을 했을때 실행할 함수 등록 
   $("#pwd").on("input", function(){
      //입력한 비밀번호를 읽어와서 
      let inputPwd=$(this).val();
      //만일 5글자 이상 입력 했으면 
      if(inputPwd.length >= 5){
         isPwdValid=true;
         $("#feedbackPwd").text("");
      }else{
         isPwdValid=false;
         $("#feedbackPwd").text("5 글자 이상 입력하세요").css("color","red");
      }
      
   });
   
   //폼에 submit 이벤트가 일어 났을때 실행할 함수 등록
   $("#signupForm").on("submit", function(){
      //만일 아이디 혹은 비밀번호가 유효하지 않으면 폼 제출을 막아야 한다. (return false)
      if(!isIdValid || !isPwdValid){
         return false;
      }
   });
</script>
</body>
</html>



