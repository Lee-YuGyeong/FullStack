<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
요청에 정확히 응답함<p/>
서버가 forward 넘겨준 값 출력 : ${requestScope.say } ${say }
<%
String imsi = (String) request.getAttribute("say");
out.print(imsi);
%>
<hr>
${msg }
</body>
</html>