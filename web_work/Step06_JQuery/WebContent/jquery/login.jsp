<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폼 전송되는 파라미터 읽어오기
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//로그인 성공 여부
	boolean isSuccess=false;
	if(id.equals("lyg") && pwd.equals("1234")){
		//로그인 처리를 한다.
		session.setAttribute("id", id);
		//성공이라고 표시한다.
		isSuccess=true;
	}
	//응답...? ajax 요청에 대한 응답은 어떤 형식으로 하는 것이 좋을까???
	
		
%>
{"isSuccess":<%=isSuccess %>, "id":"<%=id %>"}

