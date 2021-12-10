<%@page import="test.guestbook.dao.GuestBookDao"%>
<%@page import="test.guestbook.dto.GuestBookDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	//하단 시작 페이지 번호 
	int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
	//하단 끝 페이지 번호
	int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
	
	//전체 글의 갯수 
	int totalRow=GuestBookDao.getInstance().getCount();
	//전체 페이지의 갯수 구하기
	int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
	//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
	if(endPageNum > totalPageCount){
		endPageNum=totalPageCount; //보정해 준다. 
	}   
	
	//글 목록을 얻어오기
	List<GuestBookDto> list=GuestBookDao.getInstance().getList(dto);
	//EL 을 이용해서 글목록을 추출할수 있도록 request 영역에 담아둔다. 
	request.setAttribute("list", list);
	request.setAttribute("startPageNum", startPageNum);
	request.setAttribute("endPageNum", endPageNum);
	request.setAttribute("totalPageCount", totalPageCount);
	request.setAttribute("pageNum", pageNum);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/list3.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
<style>

	
	/* img  가  가운데 정렬 되도록 */
	.back-drop{
		/* 일단 숨기기 */
		display:none;
		/* 화면 전체를 투명도가 있는 회색으로 덮기 위한  css*/
		position: fixed;
		top: 0;
		right: 0;
		bottom: 0;
		left: 0;
		background-color: #cecece;
		padding-top: 300px;
		z-index: 10000;
		opacity: 0.5;
		text-align: center;
	}

	.back-drop img{
		width: 100px;
		/* rotateAnimation 이라는 키프레임을 2초 동한 일정한 비율로  무한 반복하기 */
		animation: rotateAnimation 2s ease-out infinite;
	}
	/* 회전하는 rotateAnimation 이라는 이름의 키프레임 정의하기 */
	@keyframes rotateAnimation{
		0%{
		   transform: rotate(0deg);
		}
		100%{
		   transform: rotate(360deg);
		}
	}
</style>
</head>
<body>
<div class="container">
	<a href="insertform.jsp">새글 작성</a>
	<h1>방명록 글 목록입니다.</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일</th>
				<th>이미지</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">
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
		</tbody>
	</table>
</div>
<div class="back-drop">
	<img src="${pageContext.request.contextPath}/svg/spinner.svg" />
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

	//페이지가 처음 로딩될때  1page를 보여주기때문에 초기값을 1로지정
	let currentPage=1;
	//현재 로딩중인지 여부를 관리할 변수
	let isLoading=false;
	
	//웹브라우저의 창을 스크롤 할때 마다 호출되는 함수 등록
	$(window).on("scroll", function(){
		console.log("scorll!");
		//최 하단까지 스크롤 되었는지 조사해 본다.
		//위로 스크롤된 길이
		let scrollTop=$(window).scrollTop();
		//웹브라우저 창의 높이
		let windowHeight=$(window).height();
		//문서 전체의 높이
		let documentHeight=$(document).height();
		//바닥까지 스크롤 되었는지 여부를 알아낸다. 
		let isBottom = scrollTop+windowHeight + 10 >= documentHeight;
		
		//만일 바닥까지 스크롤되고
		if(isBottom){
			
			//만일 현재페이지가 마지막 페이지이거나 아직 로딩중이라면
			if(currentPage==${totalPageCount} || isLoading){
				return; //함수를 여기서 끝내기	
			}
			//현재 로딩중이라는 상태로 바꿔준다.
			isLoading=true;
			//로딩바를 띄운다.
			$(".back-drop").show();
			//요청할 페이지 번호를 1 증가시킨다.
			currentPage++;
			//ajax 요청을 통해서 추가목록을 받아온다.
			$.ajax({
				url:"ajax_more.jsp",
				method:"post",
				data:"pageNum="+currentPage,
				success:function(responseData){
				//응답된 문자열을 tbody에 추가해서 html로 해석되게 하고
				$("tbody").append(responseData);
				//로딩바를 숨긴다.
				$(".back-drop").hide();
				//로딩이 끝났다고 상태를 바꿔준다.
				isLoading=false;
			}
			});
		}
	});
</script>
</body>
</html>