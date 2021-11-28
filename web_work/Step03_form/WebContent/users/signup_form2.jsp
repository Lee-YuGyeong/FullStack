<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form2.jsp</title>
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
   <form action="signup.jsp" method="get">
      <!-- 
         input 요소를 label 요소보다 먼저 배치하고 placehoder 속성도 추가해야 form-floating 이 동작한다.
       -->
      <div class="form-floating mb-3">
         <input class="form-control" type="text" name="nick" id="nick" placeholder="닉네임 입력..."/>
         <label class="form-label" for="nick">닉네임</label>
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
</body>
</html>


