<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step06_example3.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
   <h1>회원 가입 폼 입니다.</h1>
   <form action="signup.jsp" method="post" id="signupForm">
      <div class="mb-3">
         <label class="form-label" for="id">아이디</label>
         <input class="form-control" type="text" name="id" id="id"/>
         <div class="valid-feedback">사용 가능한 아이디 입니다</div>
         <div class="invalid-feedback">사용 불가능한 아이디 입니다</div>
      </div>
      <div class="mb-3">
         <label class="form-label" for="pwd">비밀번호</label>
         <input class="form-control" type="password" name="pwd" id="pwd"/>
         <div class="invalid-feedback">5 글자 이상 입력하세요</div>
      </div>
      <button class="btn btn-outline-success" type="submit" disabled>가입</button>
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
            //일단 두개의 클래스를 삭제
            $("#id").removeClass("is-valid is-invalid");
            if(responseData.canUse){//사용가능한 아이디
               $("#id").addClass("is-valid");
               isIdValid=true;
            }else{//사용 불가능한 아이디
               $("#id").addClass("is-invalid");
               isIdValid=false;
            }
            setButtonState();
         }
      });
      return false; //폼 제출 막기
   });
   
   //비밀번호 입력을 했을때 실행할 함수 등록 
   $("#pwd").on("input", function(){
      //입력한 비밀번호를 읽어와서 
      let inputPwd=$(this).val();
      $(this).removeClass("is-valid is-invalid");
      //만일 5글자 이상 입력 했으면 
      if(inputPwd.length >= 5){
         isPwdValid=true;
         $(this).addClass("is-valid");
      }else{
         isPwdValid=false;
         $(this).addClass("is-invalid");
      }
      setButtonState();
   });
   
   //폼에 submit 이벤트가 일어 났을때 실행할 함수 등록
   $("#signupForm").on("submit", function(){
      //만일 아이디 혹은 비밀번호가 유효하지 않으면 폼 제출을 막아야 한다. (return false)
      if(!isIdValid || !isPwdValid){
         return false;
      }
   });
   
   // submit 버튼의 상태를 변경시키는 함수 
   function setButtonState(){
      if(isIdValid && isPwdValid){//만일 폼이 유효 하다면 
         // "button[type=submit]" 
         // 선택자의 의미는 button 요소 이면서 type 속성의 값이 submit 인 요소를 선택 
         $("button[type=submit]").removeAttr("disabled");
      }else{//유효 하지 않다면
         $("button[type=submit]").attr("disabled", "disabled");
      }
   }
</script>
</body>
</html>








