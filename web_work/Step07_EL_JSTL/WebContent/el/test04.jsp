<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDto dto=new MemberDto(1,"김구라","노량진");
	//request scope 에 "dto"라는 키값으로 MemberDto type 담기
	request.setAttribute("dto", dto);
	
	//위의 코드는 서블릿에서 실행되었고 이 jsp 페이지로 forward 이동했다고 가정하자!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/el/test04.jsp</title>
</head>
<body>
	<%
		//request scope에 "dto"라는 키값으로 저장된 MemberDto 객체의 참조값 얻어오기
		MemberDto result=(MemberDto)request.getAttribute("dto");
	%>
	<h3>회원 한명의 정보입니다.</h3>
	<p>번호 : <strong><%=result.getNum() %></strong></p>
	<p>이름 : <strong><%=result.getName() %></strong></p>
	<p>주소 : <strong><%=result.getAddr() %></strong></p>
	
	<h3>회원 한명의 정보입니다.</h3>
	<p>번호 : <strong>${requestScope.dto.getNum() }</strong></p>
	<p>이름 : <strong>${requestScope.dto.getName() }</strong></p>
	<p>주소 : <strong>${requestScope.dto.getAddr() }</strong></p>
	
	<h3>회원 한명의 정보입니다.</h3>
	<p>번호 : <strong>${dto.getNum() }</strong></p>
	<p>이름 : <strong>${dto.getName() }</strong></p>
	<p>주소 : <strong>${dto.getAddr() }</strong></p>
	
	<h3>회원 한명의 정보입니다.</h3>
	<p>번호 : <strong>${dto.num }</strong></p>
	<p>이름 : <strong>${dto.name }</strong></p>
	<p>주소 : <strong>${dto.addr }</strong></p>
	
	<script>
		let myName="김구라";
		//back tick을 이용해서 문자열을 만들때 주의!!
		let str=`내 이름은 \${myName}`; //requestScope.myName, sessionScope.myName
	</script>
</body>
</html>