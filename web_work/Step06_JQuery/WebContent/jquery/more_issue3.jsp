<%@page import="org.json.JSONWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//추가 이슈를 DB에서 읽어왔다고 가정하자
	List<String> list=new ArrayList<>();
	list.add("날이 많이 추워졌어요");
	list.add("확진자가 많아졌어요");
	list.add("어쩌구.. 저쩌고..");
	//json 형식으로 응답해볼까?
	String result=JSONWriter.valueToString(list);
%>
<%=result%>