<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step04_plugin.jsp</title>
<!-- 플러그인에서 제공해주는 css 로딩 -->
<link rel="stylesheet" href="css/jquery.datetimepicker.min.css" />
<!-- jquery 로딩 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- 플러그인 javascript 로딩 -->
<script src="js/jquery.datetimepicker.full.min.js"></script>
</head>
<body>
   <input id="inputDate" type="text" placeholder="날짜 입력..."/>
   <script>
      $("#inputDate").datetimepicker();
   </script>
</body>
</html>




