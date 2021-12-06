<%@page import="test.member.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//DB에 저장된 회원 목록을 request scope 에 담았다고 가정하자
	List<MemberDto> list=new ArrayList<>();
	list.add(new MemberDto(1,"김구라","노량진"));
	list.add(new MemberDto(2,"해골","행신동"));
	list.add(new MemberDto(3,"원숭이","상도동"));
	
	request.setAttribute("list", list);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jstl/test02.jsp</title>
</head>
<body>
	<h1>회원 목록입니다.</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.name }</td>
					<td>${tmp.addr }</td>				
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>