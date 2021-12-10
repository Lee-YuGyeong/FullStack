<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="java.util.List"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
   //한 페이지에 몇개씩 표시할 것인지
   final int PAGE_ROW_COUNT=10;
   //하단 페이지를 몇개씩 표시할 것인지
   final int PAGE_DISPLAY_COUNT=5;
   
   //보여줄 페이지의 번호를 일단 1이라고 초기값 지정
   int pageNum=1;
   //페이지 번호가 파라미터로 전달되는지 읽어와 본다.
   String strPageNum=request.getParameter("pageNum");
   //만일 페이지 번호가 파라미터로 넘어 온다면
   if(strPageNum != null){
      //숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
      pageNum=Integer.parseInt(strPageNum);
   }
   
   //보여줄 페이지의 시작 ROWNUM
   int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
   //보여줄 페이지의 끝 ROWNUM
   int endRowNum=pageNum*PAGE_ROW_COUNT;
   
   GuestBookDto dto=new GuestBookDto();
   dto.setStartRowNum(startRowNum);
   dto.setEndRowNum(endRowNum);
   //글 목록을 얻어오기
   List<GuestBookDto> list=GuestBookDao.getInstance().getList(dto);
   //EL 을 이용해서 글목록을 추출할수 있도록 request 영역에 담아둔다. 
   request.setAttribute("list", list);
   
   //테스트를 위해 시간을 좀 지연시켜 보기
   Thread.sleep(3000);
   
%>    
<%-- tbody 에 추가할 table row 만 반목문 돌면서 출력해 준다. --%>
<c:forEach var="tmp" items="${list }">
   <tr>
      <td>${tmp.num }</td>
      <td>${tmp.writer }</td>
      <td>
         <a href="detail.jsp?num=${tmp.num }">${tmp.title }</a>
      </td>
      <td>${tmp.regdate }</td>
      <td><img src="https://ucarecdn.com/05f649bf-b70b-4cf8-90f7-2588ce404a08/" style="width:200px"/></td>
   </tr>
</c:forEach>






