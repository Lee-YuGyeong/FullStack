<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/insertform.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<h1>방명록에 글을 남겨 주세요</h1>
	<form action="insert.jsp" method="post" id="insertForm">
	   <div class="mb-3">
	      <label class="form-label" for="writer">작성자</label>
	      <input class="form-control" type="text" name="writer" id="writer"/>
	      <div class="invalid-feedback">2글자 이상 10자 이내로 작성하세요</div>
	   </div>
	   <div class="mb-3">
	      <label class="form-label" for="title">제목</label>
	      <input class="form-control" type="text" name="title" id="title"/>
	      <div class="invalid-feedback">2글자 이상 20자 이내로 작성하세요</div>
	   </div>
	   <div class="mb-3">
	      <label class="form-label" for="content">글내용</label>
	      <textarea class="form-control" name="content" id="content" cols="30" rows="10"></textarea>
	      <div class="invalid-feedback">100글자 이내로 작성하고 영문자는 허용하지 않습니다.</div>
	   </div>
	   <div class="mb-3">
	      <label class="form-label" for="pwd">비밀번호</label>
	      <input class="form-control" type="password" name="pwd" id="pwd"/>
	      <div class="invalid-feedback">영문자로 시작하고 2글자 이상 이내로 작성하세요.</div>
	   </div>
	   <div class="mb-3">
	      <label class="form-label" for="pwd2">비밀번호 확인</label>
	      <input class="form-control" type="password" name="pwd2" id="pwd2"/>
	      <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
	   </div>
	   <button class="btn btn-outline-primary type="submit">저장하기</button>
	</form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	//유효성 여부 검사
	let isWriterValid=false;
	let isTitleValid=false;
	let isContentValid=false;
	let isPwdValid=false;
	let isPwd2Valid=false;
	
	$("#writer").on("input", function(){
	   //입력한 작성자를 읽어와서
	   let inputWriter=$(this).val();
	   //최소 2글자 최대 10글자 인지 여부를 검증할 정규표현식 객체를 만들어서
	   let reg=/^.{2,10}$/;
	   //매칭여부를 판단
	   if(reg.test(inputWriter)){
	      $(this).removeClass("is-invalid").addClass("is-valid");
	      isWriterValid=true;
	   }else{//매칭이 안된다면
	      isWriterValid=false;
	        $(this).removeClass("is-valid").addClass("is-invalid");
	   }
	});
	
	$("#title").on("input", function(){
	   //입력한 타이틀를 읽어와서
	   let inputTitle=$(this).val();
	   //최소 2글자 최대 20글자 인지 여부를 검증할 정규표현식 객체를 만들어서
	   let reg=/^.{2,10}$/;
	   //매칭여부를 판단
	   if(reg.test(inputTitle)){
	      $(this).removeClass("is-invalid").addClass("is-valid");
	      isTitleValid=true;
	   }else{//매칭이 안된다면
	      isTitleValid=false;
	        $(this).removeClass("is-valid").addClass("is-invalid");
	   }
	});
	
	$("#content").on("input", function(){
	   //입력한 타이틀를 읽어와서
	   let inputContent=$(this).val();
	   //100 글자 이내로 작성하고 영문자는 허용하지 않는 정규표현식 객체를 만들어서
	   let reg=/^[^A-Za-z]{0,100}$/;
	   //매칭여부를 판단
	   if(reg.test(inputContent)){
	      $(this).removeClass("is-invalid").addClass("is-valid");
	      isContentValid=true;
	   }else{//매칭이 안된다면
	      isContentValid=false;
	        $(this).removeClass("is-valid").addClass("is-invalid");
	   }
	});
	
	$("#pwd").on("input", function(){
	   //입력한 타이틀를 읽어와서
	   let inputPwd=$(this).val();
	   //영문자로 시작하고 2글자 이상 10글자 이내로 작성하세요
	   let reg=/^[a-zA-Z].{1,9}$/;
	   //매칭여부를 판단
	   if(reg.test(inputPwd)){
	      $(this).removeClass("is-invalid").addClass("is-valid");
	      isPwdValid=true;
	   }else{//매칭이 안된다면
	      isPwdValid=false;
	        $(this).removeClass("is-valid").addClass("is-invalid");
	   }
	});
	
	$("#pwd,#pwd2").keyup(function(){
	   let pwd=$("#pwd").val();
	   let pwd2=$("#pwd2").val();
	   $("#pwd2").removeClass("is-valid is-invalid");
	   if(pwd==pwd2){
	      isPwd2Valid=true;
	      $("#pwd2").addClass("is-valid");
	   }else{
	      isPwd2Valid=false;
	      $("#pwd2").addClass("is-invalid");
	   }
	});
	
	//폼에 submit 이벤트가 일어 났을때 실행할 함수 등록 
	$("#insertForm").on("submit", function(){
	   //만일 폼 전체가 유효하지 않는다면 (입력필드 중에서 어느하나라도 유효하지 않는다면 폼 제출 막기)
	    if(!isWriterValid||!isTitleValid||!isPwdValid||!isPwd2Valid||!isContentValid){
	      //폼제출 막기(jquery 에서만 가능)
	      return false;
	      }
	   });
		
	
</script>
</body>
</html>





