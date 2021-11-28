<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/loginform.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body class="text-center">

<div class="container">
   <h3>로그인 폼</h3>
   <form action="login.jsp" method="post">
      <div class="mb-3">
         <label class="form-label" for="id">아이디</label>
         <input class="form-control" type="text" name="id" id="id"/>
      </div>
      <div class="mb-3">
         <label class="form-label" for="pwd">비밀번호</label>
         <input class="form-control" type="password" name="pwd" id="pwd"/>
      </div>
      <button class="btn btn-outline-primary btn-sm" type="submit">로그인</button>
   </form>
</div>
</body>
</html>


