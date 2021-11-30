<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃 처리하고
	session.removeAttribute("id");
	//리다이렉트 이동
	String cPath=request.getContextPath();
	response.sendRedirect(cPath+"/jquery/Step06_ajaxLogin.jsp");
%>