<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//한글깨지지 않도록 인코딩 설정
	request.setCharacterEncoding("utf-8");
	//content 라는 파라미터명으로 전송되는 문자열 읽어오기
	String content=request.getParameter("content");
	//실제 프로젝트에서는 DB에 저장을 해야하지만 여기에서는 그냥 사용해보기로 하자..
	//DB에서 읽어왔다고 가정하고 request에 담기
	request.setAttribute("content", content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>save.jsp</title>
</head>
<body>
	<h3>p요소에 글내용을 그대로 출력하면?</h3>
	<p>${content}</p>
	
	<h3>textarea에 출력하면?</h3>
	<%-- textarea에 초기값을 지정하는 방법을 정리하세요 --%>
	<textarea cols="30" rows="10">${content }</textarea>
	<%
		//페이지 영역에 newLine이라는 키값으로 개행기호 담기
		pageContext.setAttribute("newLine", "\n");
	%>
	<p>${fn:replace(content,newLine,'<br>')  }</p>

</body>
</html>