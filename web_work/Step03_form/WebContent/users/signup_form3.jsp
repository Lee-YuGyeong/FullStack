<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form3.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<style>
   .legend-style{
      font-size: 16px;
   }
</style>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
   <!-- 
      signup.jsp 페이지에서 폼 전송되는 내용을 아래의 테이블에 저장되는 기능을 구현해 보세요.
      
      lan 칼럼에는 선택하지 않으면 NULL 을 넣고
      Java 를 선택하면 Java
      Java 와 Python 을 선택하면  Java,Python
      Java 와 Python 과 C++ 를 선택하면 Java,Python,C++  
      문자열이 저장되도록 하세요. 
      
      CREATE TABLE form_test(
         nick VARCHAR2(20) PRIMARY KEY,
         email CHAR(3),
         concern VARCHAR2(10),
         lan VARCHAR2(30),
         comm CLOB 
      );
    -->
   <h1>회원 가입 폼 입니다.</h1>
   <form action="signup.jsp" method="get" id="signupForm">
      <!-- 
         input 요소를 label 요소보다 먼저 배치하고 placehoder 속성도 추가해야 form-floating 이 동작한다.
       -->
      <div class="form-floating mb-3">
         <input class="form-control" type="text" name="nick" id="nick" placeholder="닉네임 입력..."/>
         <label class="form-label" for="nick">닉네임</label>
         <div class="valid-feedback">
            사용가능한 닉네임 입니다.
         </div>
         <div class="invalid-feedback">
            5글자 이상 10글자 이하로 작성해 주세요.
         </div>
      </div>
      <fieldset>
         <legend class="legend-style">이메일 수신여부</legend>
         <div class="btn-group mb-3">
            <input class="btn-check" id="emailYes" type="radio" name="email" value="yes" checked/>
            <label class="btn btn-outline-success btn-sm" for="emailYes">네</label>
            
            <input class="btn-check" id="emailNo" type="radio" name="email" value="no"/>
            <label class="btn btn-outline-danger btn-sm" for="emailNo">아니요</label>
         </div>   
      </fieldset>
      <div class="form-floating mb-3">
         <select class="form-select" name="concern" id="concern">
            <option value="">선택</option>
            <option value="game">게임</option>
            <option value="movie">영화</option>
            <option value="etc">기타</option>
         </select>
         <label class="form-label" for="concern">관심사</label>
         <div class="invalid-feedback">
            관심사는 반드시 선택해야 합니다.
         </div>
      </div>
      <fieldset>
         <legend class="legend-style">배우고 싶은 언어</legend>
         <div class="btn-group mb-3">
            <input class="btn-check" id="language1" type="checkbox" name="language" value="Java"/>
            <label class="btn btn-outline-secondary btn-sm" for="language1">자바</label>
            
            <input class="btn-check" id="language2" type="checkbox" name="language" value="Python"/>
            <label class="btn btn-outline-secondary btn-sm" for="language2">파이썬</label>
            
            <input class="btn-check" id="language3" type="checkbox" name="language" value="C++"/>
            <label class="btn btn-outline-secondary btn-sm" for="language3">C++</label>
         </div>
      </fieldset>
      <div class="form-floating mb-3">
         <textarea style="height:150px;" placeholder="leave comment!" class="form-control" id="comment" name="comment" ></textarea>
         <label class="form-label" for="comment">남기고 싶은말</label>
      </div>
      <button class="btn btn-success" type="submit">가입</button>
      <button class="btn btn-warning" type="reset">취소</button>
   </form>
</div>
<script>
   //닉네임의 유효성 여부를 저장할 변수를 만들고 초기값 false 부여
   let isNickValid=false;
   //관심사의 유효성 여부(선택했는지여부)를 저장할 변수를 만들고 초기값 false 부여
   let isConcernValid=false;

   // id 가 nick 인 input 요소에 input 이벤트가 일어났을때 실행할 함수 등록 
   document.querySelector("#nick").addEventListener("input", function(){
      //1. 입력한 value 값을 읽어온다.
      let inputNick=this.value;
      //2. 유효성(5글자이상 10글자 이하)을 검증한다.
      isNickValid = inputNick.length >= 5 && inputNick.length <= 10;
      //3. 유효하다면 input 요소에 is-valid 클래스 추가, 아니라면 is-invalid 클래스 추가
      if(isNickValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
      }
   });
   
   document.querySelector("#concern").addEventListener("change", function(){
      //select 에 선택 혹은 입력한 문자열을 읽어와서
      let inputConcern=this.value;
      //길이가 0보다 큰지 확인해서 
      isConcernValid=inputConcern.length > 0;
      if(isConcernValid){
         this.classList.remove("is-invalid");
         this.classList.add("is-valid");
      }else{
         this.classList.remove("is-valid");
         this.classList.add("is-invalid");
      }
      
   });
   
   //폼에 submit 이벤트가 일어 났을때 실행할 함수 등록
   document.querySelector("#signupForm").addEventListener("submit", function(e){
      //만일 폼이 유효하지 않는다면 전송을 막아주기
      if(!isNickValid || !isConcernValid){
         //이벤트 객체의 함수를 이용해서 폼 전송 막아주기 
         e.preventDefault();
      }
   });
</script>
</body>
</html>









