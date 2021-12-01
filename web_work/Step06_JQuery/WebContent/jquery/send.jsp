<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//ajax 요청할때 data : "msg=xxx"
	String msg=request.getParameter("msg");
	System.out.println(msg);
%>
okay~