
<%@page import="test.dao.MemberDao"%>
<%@page import="test.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list.jsp</title>
<link rel="stylesheet" href="/Step01_Example/css/bootstrap.css" />
<script src="/Step01_Example/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
	List<MemberDto> list = new MemberDao().getList();	
%>
<div class="table table-striped">
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
		<%
			for(MemberDto tmp:list){%>
				<tr>
					<td><%=tmp.getNum() %></td>
					<td><%=tmp.getName() %></td>
					<td><%=tmp.getAddr() %></td>
					<td><a href="delete.jsp?num=<%=tmp.getNum()%>">삭제</a></td>
				</tr>
			<%} %>
		
		</tbody>
	</table>
</div>
<ul>
	<%for(int i=0;i<5;i++){%>
		<li>오잉?<%=i %></li>
	<%}%>
</ul>
</body>
</html>