<%@page import="java.util.List"%>
<%@page import="test.member.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//DB 에서 읽어온 추가 회원 목록이라고 가정하자
	List<MemberDto> list=new ArrayList<>();
	list.add(new MemberDto(2,"최00","대구"));
	list.add(new MemberDto(3,"이00","서울"));
	list.add(new MemberDto(4,"박00","부산"));
%>
<%for(MemberDto tmp:list){ %>
	<tr>
		<td><%=tmp.getNum() %></td>
		<td><%=tmp.getName() %></td>
		<td><%=tmp.getAddr() %></td>
	</tr>
<%}%>