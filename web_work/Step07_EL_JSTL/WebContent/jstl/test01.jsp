<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	/WEB-INF/lib/jstl.jar 파일로부터 core 라이브러리를 import(불러와서) 해서
	c 라는 접두어로서 사용하겠다는 의미 
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//테스트를 위해 sample 데이터를 request 영역에 담는다.
	List<String> names=new ArrayList<>();
	names.add("김구라");
	names.add("해골");
	names.add("원숭이");
	
	request.setAttribute("names", names);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jstl/test01.jsp</title>
</head>
<body>
	<h1>JSTL (Jsp Standard Tag Library)</h1>
	<c:forEach var="i" begin="0" end="9" step="2">
		<p>안녕 ${i }</p>
	</c:forEach>
	
	<%
		List<String> result=(List<String>)request.getAttribute("names");
	%>
	<h3>친구 목록입니다.</h3>
	<ul>
		<%for(String tmp:result){ %>
			<li><%=tmp %></li>
		<%} %>

	</ul>
	
	<h3>친구 목록입니다. (EL + JSTL 활용)</h3>
	<ul>
		<c:forEach var="tmp" items="${requestScope.names }">
			<li>${tmp }</li>	
		</c:forEach>
	</ul>

	<h3>친구 목록입니다. 인덱스 표시</h3>
	<ul>
		<c:forEach var="tmp" items="${names }" varStatus="status">
			<li>
				${tmp }
				${status.index }
			</li>
		</c:forEach>
	</ul>   

	<h3>친구 목록입니다. 순서 표시</h3>
	<ul>
		<c:forEach var="tmp" items="${names }" varStatus="status">
			<li>
				${tmp }
				${status.count }
			</li>
		</c:forEach>
	</ul>
	
	<h3>친구 목록입니다. 첫번째 아이템 여부</h3>
	<ul>
		<c:forEach var="tmp" items="${names }" varStatus="status">
			<li>
				${tmp }
				첫번째 아이템 여부 : ${status.first }
			</li>
		</c:forEach>
	</ul>  
	
	<h3>친구 목록입니다. 마지막번째 아이템인지 여부</h3>
	<ul>
		<c:forEach var="tmp" items="${names }" varStatus="status">
			<li>
				${tmp }
				마지막번째 아이템인지 여부 : ${status.last }
			</li>
		</c:forEach>
	</ul> 
	
	
</body>
</html>