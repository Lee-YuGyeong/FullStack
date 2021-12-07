<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup/close.jsp</title>
</head>
<body>
<%
	//체크박스를 체크했는지 여부를 읽어와본다.(체크했으면 "no" 안했으면  null이다.)
	String canPopup=request.getParameter("canPopup");
	//만일 팝업을 띄우지 않겠다고 체크박스를 체크했다면
	if(canPopup!=null){
		//팝업을 띄우지 않겠다는 정보를 쿠기로 응답한다.
		Cookie cook=new Cookie("canPopup",canPopup);
		cook.setMaxAge(60);
		response.addCookie(cook);	
	}

%>
<script>
	//javascript를 활용해서 팝업창 닫기
	self.close();
</script>
</body>
</html>