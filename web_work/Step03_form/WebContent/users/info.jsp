<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //파라미터로 넘어오는 nick 
   String nick=request.getParameter("nick");
   //1. nick 에 해당되는 회원정보를 읽어와서
   UsersDto dto=UsersDao.getInstance().getData(nick);
   if(dto.getConcern()==null){
      dto.setConcern("");
   }
   if(dto.getLan()==null){
      dto.setLan("");
   }
   //2. 가입정보를 응답한다. 
   System.out.println(dto.getEmail());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/info.jsp</title>
</head>
<body>
<div class="container">
   <h1>가입된 정보 입니다.</h1>
      닉네임 
      <input type="text" name="nick" value="<%=dto.getNick()%>"/><br/>
      이메일 수신 여부
      <label>
         <input type="radio" name="email" value="yes" <%=dto.getEmail().equals("yes") ? "checked":"" %>/> 네
      </label>
      <label>
         <input type="radio" name="email" value="no" <%=dto.getEmail().trim().equals("no") ? "checked":"" %>/> 아니요
      </label>
      <br/>
      관심사  
      <select name="concern">
         <option value="">선택</option>
         <option value="game" <%=dto.getConcern().equals("game") ? "selected":"" %>>게임</option>
         <option value="movie" <%=dto.getConcern().equals("movie") ? "selected":"" %>>영화</option>
         <option value="etc" <%=dto.getConcern().equals("etc") ? "selected":"" %>>기타</option>
      </select>
      <br/>
      배우고 싶은 언어 체크
      <label>
         <input type="checkbox" name="language" value="Java" <%=dto.getLan().contains("Java") ? "checked":"" %>/> 자바
      </label>
      <label>
         <input type="checkbox" name="language" value="Python" <%=dto.getLan().contains("Python") ? "checked":"" %>/> 파이선
      </label>
      <label>
         <input type="checkbox" name="language" value="C++" <%=dto.getLan().contains("C++") ? "checked":"" %>/> C++
      </label>
      <br/>
      남기고 싶은 말
      <textarea name="comment" cols="30" rows="10"><%=dto.getComm() %></textarea>
</div>   
</body>
</html>


