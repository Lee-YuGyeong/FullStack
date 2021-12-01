<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//파라미터로 전달되는 아이디를 읽어와서
	String inputId = request.getParameter("inputId");
	//사용가능한 아이디인지 여부를 알아내서
	boolean canUse=true;
	 //DB 에 이미 gura , monkey 라는 아이디가 있다고 가정하자 
	if(inputId.equals("gura") || inputId.equals("monkey")){
		canUse=false;
	}
	//JSON 문자열로 응답한다.
%>
{"canUse":<%=canUse%>}