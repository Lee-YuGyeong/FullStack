<%@page import="test.member.dto.MemberDto"%>
<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/updateform.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
   //1. get 방식 파라미터로 전달되는 수정할 회원의 번호를 읽어와서
   int num=Integer.parseInt(request.getParameter("num"));
   //2. DB 에서 해당회원의 정보를 얻어와서
   MemberDto dto=MemberDao.getInstance().getData(num);
   //3. 회원 정보 수정 폼에 회원정보를 출력해 준다.
%>
<jsp:include page="/include/navbar.jsp">
	<jsp:param value="member" name="thisPage"/>
</jsp:include>
<div class="container">
   <nav aria-label="breadcrumb">
     <ol class="breadcrumb">
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/member/list.jsp">회원목록</a></li>
       <li class="breadcrumb-item active">회원 수정</li>
     </ol>
   </nav>
   <h1>회원 정보 수정 폼</h1>
   <form action="update.jsp" method="post">
      <!-- 
         disabled 된 input 요소는 폼을 제출했을때 전송도 되지 않는다.
         따라서 회원의 번호를 눈에 보이지는 않지만 폼을 제출했을때 같이 제출되도록
         input type="hidden" 요소를 이용해서 보내 주어야 한다. 
       -->
      <input type="hidden" name="num" value="<%=dto.getNum() %>"/>
      <div class="mb-3">
         <label class="form-label" for="num">번호</label>
         <input class="form-control" type="text" id="num" value="<%=dto.getNum()%>" disabled/>
      </div>
      <div class="mb-3">
         <label class="form-label" for="name">이름</label>
         <input class="form-control"  type="text" name="name" id="name" value="<%=dto.getName() %>"/>
      </div>
      <div class="mb-3">
         <label class="form-label" for="addr">주소</label>
         <input class="form-control" type="text" name="addr" id="addr" value="<%=dto.getAddr() %>"/>
      </div>
      <button class="btn btn-success" type="submit">수정확인</button>
      <button class="btn btn-warning" type="reset">취소</button>
   </form>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>