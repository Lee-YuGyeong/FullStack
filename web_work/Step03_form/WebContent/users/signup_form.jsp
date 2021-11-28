<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup_form.jsp</title>
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
      <div class="mb-3">
         <label class="form-label" for="nick">닉네임</label>
         <input class="form-control" type="text" name="nick" id="nick"/>
      </div>
      <fieldset>
         <legend class="legend-style">이메일 수신여부</legend>
         <div class="form-check form-check-inline">
            <input class="form-check-input" id="emailYes" type="radio" name="email" value="yes" checked/>
            <label class="form-check-label" for="emailYes">네</label>
         </div>
         <div class="form-check form-check-inline">
            <input class="form-check-input" id="emailNo" type="radio" name="email" value="no" />
            <label class="form-check-label" for="emailNo">아니요</label>
         </div>         
      </fieldset>
      <div class="mb-3">
         <label class="form-label" for="concern">관심사</label>
         <select class="form-select" name="concern" id="concern">
            <option value="">선택</option>
            <option value="game">게임</option>
            <option value="movie">영화</option>
            <option value="etc">기타</option>
         </select>
      </div>
      <fieldset>
         <legend class="legend-style">배우고 싶은 언어</legend>
         <div class="form-check">
            <input class="form-check-input" id="language1" type="checkbox" name="language" value="Java"/>
            <label class="form-check-label" for="language1">자바</label>
         </div>
         <div class="form-check">
            <input class="form-check-input" id="language2" type="checkbox" name="language" value="Python"/>
            <label class="form-check-label" for="language2">파이썬</label>
         </div>
         <div class="form-check">
            <input class="form-check-input" id="language3" type="checkbox" name="language" value="C++"/>
            <label class="form-check-label" for="language3">C++</label>
         </div>
      </fieldset>
      <div class="mb-3">
         <label class="form-label" for="comment">남기고 싶은말</label>
         <textarea class="form-control" id="comment" name="comment" ></textarea>
      </div>
      <button class="btn btn-success" type="submit">가입</button>
      <button class="btn btn-warning" type="reset">취소</button>
   </form>
</div>
</body>
</html>


