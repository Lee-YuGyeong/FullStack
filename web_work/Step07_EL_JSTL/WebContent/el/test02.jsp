<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request scope(영역)에 "fortuneToday"라는 키값으로 String type 담기
	request.setAttribute("fortuneToday", "동쪽으로 가면 귀인을 만나요");

	//위의 코드는 서블릿에서 실행되었고 이 jsp 페이지로 forward 이동했다고 가정하자!
	request.getAttribute("fortuneToday");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/test02.jsp</title>
</head>
<body>
	<%
		//request scope(영역)에 "fortuneToday"라는 키값으로 저장된 String type 데이터 읽어오기
		String fortune=(String)request.getAttribute("fortuneToday");
	%>
	<p>오늘의 운세 : <strong><%=fortune %></strong></p>
	<p>오늘의 운세 : <strong>${requestScope.fortuneToday}</strong></p>
	<p>오늘의 운세 : <strong>${fortuneToday }</strong></p>
</body>
</html>