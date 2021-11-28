<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //한글 깨지지 않도록
   request.setCharacterEncoding("utf-8");

   //닉네임 읽어오기
   String nick=request.getParameter("nick");
   //이메일 수신여부  "yes" or "no"
   String email=request.getParameter("email");
   //관심사 읽어오기  "" or "game" or "movie" or "etc"
   String concern=request.getParameter("concern");
   /*
      배우고 싶은 언어 읽어오기
      - checkbox 는 동일한 파라미터 명으로 여러개의 값이 넘어올 가능성이 있기때문에
        .getParameterValues("파라미터명") 메소드를 이용해서 값을 읽어와야 한다.
      - 체크된 체크박스가 하나도 없으면 null 일수도 있다. (NullPointerException 주의!)
      
      - null 이 아니라면 language 는
      
      ["Java"] or ["Python"] or ["C++"] or ["Java","Phtyon"] or ["Java","C++"]
       or ["Python","C++"]  or ["Java","Phthon","C++"] 중에 하나이다. 
   */
   String[] language=request.getParameterValues("language");
   /*
      DB 에 저장할때 배열째로 저장할수 없으니 배열에 저장된 내용을 문자열 1줄로 변환한다.
      ex)
        Java,Phthon,C++
        or
        Java/Python/C++
        ...
        1줄로 변환한후 DB 에 하나의 칼럼에 저장한다. 
        - 변환하는 방법
        String result = String.join("구분자", String 배열);
   */
   String savedLan = "";
   //체크박스를 하나도 체크하지 않았다면 null이다.
   if(language != null){
	   savedLan=String.join(",", language);
   }

   //남기고 싶은말 textarea 에 입력했기 때문에  개행기호(\r\n)도 함께 읽어온다
   String comment=request.getParameter("comment");
   //DB 에 저장하기
   UsersDto dto=new UsersDto();
   dto.setNick(nick);
   dto.setEmail(email);
   dto.setConcern(concern); // concern 이 빈 문자열 "" 이면 DB에 저장했을때 칼럼에 null 이 들어간다.
   dto.setLan(savedLan);
   dto.setComm(comment);
   
   boolean isSuccess=UsersDao.getInstance().insert(dto);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup.jsp</title>
</head>
<body>
<div class="container">
   <h1>알림</h1>
   <%if(isSuccess){ %>
      <p>
         <strong><%=nick %></strong> 회원님 가입 되었습니다.
         <a href="info.jsp?nick=<%=nick%>">가입정보 확인하기</a>
      </p>
   <%}else{ %>
      <p>
         가입 실패!
         <a href="signup_form.jsp">다시 시도</a>
      </p>
   <%} %>
</div>   
</body>
</html>


