<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step07_example.jsp</title>
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
         <div class="invalid-feedback">영문자로 시작하고 5글자 이상 10글자 이내로 입력하세요</div>
      </div>
      <div class="mb-3">
         <label class="form-label" for="pwd">비밀번호</label>
         <input class="form-control" type="password" name="pwd" id="pwd"/>
         <div class="invalid-feedback">특수 문자를 하나이상 포함하세요</div>
      </div>
      <div class="mb-3">
         <label class="form-label" for="pwd2">비밀번호 확인</label>
         <input class="form-control" type="password" name="pwd2" id="pwd2"/>
         <div class="invalid-feedback">위의 비밀번호와 일치하지 않습니다</div>
      </div>
      <button class="btn btn-outline-success" type="submit" disabled>가입</button>
   </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
   //아이디의 유효성 여부
   let isIdValid=false;
   //비밀번호에 특수 문자가 포함 되었는지 여부
   let isPwdValid=false;
   //두개의 비밀번호가 일치하는지 여부 
   let isPwdEqual=false;

   $("#id").on("input", function(){
      //입력한 아이디를 읽어와서 
      let inputId=$("#id").val();
      //아이디를 제대로 입력했는지 검증할 정규표현식
      let reg=/^[a-zA-Z].{4,9}$/;
      //이벤트가 일어난 바로 그 요소를 선택해서 두개의 클래스를 일단 제거 한다. 
      $(this).removeClass("is-valid is-invalid");
      if(reg.test(inputId)){//만일 정규표현식을 통과 한다면 
         isIdValid=true;
         $(this).addClass("is-valid");
      }else{//통과 하지 못한다면 
         isIdValid=false;
         $(this).addClass("is-invalid");
      }
      setButtonState();
      return false; //폼 제출 막기
   });
   
   //비밀번호 입력을 했을때 실행할 함수 등록 
   $("#pwd").on("input", function(){
      //입력한 비밀번호를 읽어와서 
      let inputPwd=$(this).val();
      //특수문자가 포함되어 있는지 여부를 검증할 정규 표현식
      let reg=/[\W]+/;
      $(this).removeClass("is-valid is-invalid");
      if(reg.test(inputPwd)){//만일 특수문자를 하나이상 포함하고 있다면
         isPwdValid=true;
         $(this).addClass("is-valid");
      }else{//그렇지 않다면
         isPwdValid=false;
         $(this).addClass("is-invalid");
      }
      setButtonState();
   });
   //비밀번호 확인 입력을 했을때 실행할 함수 등록 
   $("#pwd2").on("input", function(){
      //입력한 비밀번호 두개를 읽어와서  
      let inputPwd=$("#pwd").val();
      let inputPwd2=$(this).val();
      //두 비밀번호가 일치하는지 여부를 미리 만들어진 변수에 저장한다.
      isPwdEqual = inputPwd == inputPwd2;
      $(this).removeClass("is-valid is-invalid");
      if(isPwdEqual){//만일 비밀번호 2개가 일치 한다면 
         $(this).addClass("is-valid");
      }else{//일치하지 않는다면 
         $(this).addClass("is-invalid");
      }
      setButtonState();
   });   
   
   //폼에 submit 이벤트가 일어 났을때 실행할 함수 등록
   $("#signupForm").on("submit", function(){
      //만일 아이디 혹은 비밀번호가 유효하지 않으면 폼 제출을 막아야 한다. (return false)
      if(!isIdValid || !isPwdValid || !isPwdEqual){
         return false;
      }
   });
   
   // submit 버튼의 상태를 변경시키는 함수 
   function setButtonState(){
      if(isIdValid && isPwdValid && isPwdEqual){//만일 폼이 유효 하다면 
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








