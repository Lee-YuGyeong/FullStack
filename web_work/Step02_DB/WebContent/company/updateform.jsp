<%@page import="test.company.dto.CompanyDto"%>
<%@page import="test.company.dao.CompanyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/company/updateform.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
   //1. get 방식 파라미터로 전달되는 수정할 회원의 번호를 읽어와서
   int empno=Integer.parseInt(request.getParameter("empno"));
   //2. DB 에서 해당회원의 정보를 얻어와서
   CompanyDto dto=CompanyDao.getInstance().getData(empno);
   //3. 회원 정보 수정 폼에 회원정보를 출력해 준다.
%>
<jsp:include page="/include/navbar.jsp">
	<jsp:param value="company" name="thisPage"/>
</jsp:include>
<div class="container">
   <nav aria-label="breadcrumb">
     <ol class="breadcrumb">
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/company/list.jsp">회원목록</a></li>
       <li class="breadcrumb-item active">사원 수정</li>
     </ol>
   </nav>
   <h1>사원 정보 수정 폼</h1>
   <form action="update.jsp" method="post">
      <!-- 
         disabled 된 input 요소는 폼을 제출했을때 전송도 되지 않는다.
         따라서 회원의 번호를 눈에 보이지는 않지만 폼을 제출했을때 같이 제출되도록
         input type="hidden" 요소를 이용해서 보내 주어야 한다. 
       -->
      <input type="hidden" name="empno" value="<%=dto.getEmpno()%>"/>
      <div class="mb-3">
         <label class="form-label" for="empno">사원 번호</label>
         <input class="form-control" type="text" id="empno" value="<%=dto.getEmpno() %>" disabled/>
      </div>
      <div class="mb-3">
         <label class="form-label" for="ename">사원 이름</label>
         <input class="form-control" type="text" name="ename" id="ename" value="<%=dto.getEname() %>"/>
      </div>
      <div class="mb-3">
         <label class="form-label" for="job">직책</label>
         <input class="form-control"  type="text" name="job" id="job" value="<%=dto.getJob() %>"/>
      </div>
      <div class="mb-3">
         <label class="form-label" for="hiredate">입사일</label>
         <input class="form-control" type="text" name="hiredate" id="hiredate" value="<%=dto.getHiredate() %>"/>
      </div>
      <button class="btn btn-success" type="submit">수정확인</button>
      <button class="btn btn-warning" type="reset">취소</button>
   </form>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>