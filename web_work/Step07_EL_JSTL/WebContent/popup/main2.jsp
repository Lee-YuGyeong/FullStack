<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup/main2.jsp</title>
</head>
<body>

	<h1>팝업 테스트 페이지 입니다.</h1>
	<script>
	/*   
	[ 팝업 옵션 문자열 ]
	
	yes나 no로 지정하면 됩니다.
	toolbar = 상단 도구창 출력 여부 
	menubar = 상단 메뉴 출력 여부
	location = 메뉴아이콘 출력 여부
	directories = 제목 표시줄 출력 여부
	status = 하단의 상태바 출력 여부
	scrollbars = 스크롤바 사용 여부
	resizable = 팝업창의 사이즈 변경 가능 여부
	
	사이즈 정의(픽셀 px)
	width = 팝업창의 가로 길이 설정
	height = 팝업창의 세로 길이 설정
	top = 팝업창이 뜨는 위치(화면 위에서부터의 거리 지정)
	left = 팝업창이 뜨는 위치(화면 왼쪽에서부터의 거리 지정)
	*/
	
	//팝업 띄우는 함수 
	function showPopup(){
	   window.open("popup_page.jsp","팝업창","width=400,height=300,top=100,left=100");
	}
	
	//팝업을 중앙에 띄우는 함수 
	function showPopup2(){
	   PopupCenter("popup_page2.jsp","팝업창", 800, 500);
	}
	
	//팝업을 중앙에 원하는 페이지를 원하는  크기로 띄우는 함수 
	function PopupCenter(url, title, w, h) {
	   // Fixes dual-screen position                         Most browsers      Firefox
	   var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
	   var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;
	   
	   width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
	   height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;
	   
	   var left = ((width / 2) - (w / 2)) + dualScreenLeft;
	   var top = ((height / 2) - (h / 2)) + dualScreenTop;
	   var newWindow = window.open(url, title, 'scrollbars=yes, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
	   
	   // Puts focus on the newWindow
	   if (window.focus) {
	       newWindow.focus();
	   }
	}
	</script>
	<%--
		쿠기에 canPopup 이라는 키값으로 저장된게 없으면 (비었으면) 팝업 띄우기
	 --%>
	<c:if test="${ empty cookie.canPopup }">
		<script>
			//페이지 로딩시점에 팝업 페이지를 띄우고 싶으면 여기서 팝업을 띄우는 함수를 호출하면 된다.
			showPopup2();
		</script>
	</c:if>
   
</body>
</html>