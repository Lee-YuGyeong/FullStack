<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function myfunc(buser_no){
		//alert(buser_no);
		$("#showData").empty();
		
		$.ajax({
			type:"get",
			url:"jikwoninfo?buser_no=" + buser_no,
			dataType:"json",
			success:function(jikwonData){
				//alert(jikwonData);
				let count = 0;
				let str = "** 직원 정보(json) **<br>";
				str += "<table border='1'>";
				str += "<tr><th>사번</th><th>이름</th><th>직급</th><tr>";
				let jiklist = jikwonData.datas;	//서버에서 전송된 자료 수신
				
				$(jiklist).each(function(ind, obj){
					str += "<tr>";
					str += "<td>" + obj.sabun + "</td>";
					str += "<td>" + obj.irum + "</td>";
					str += "<td>" + obj.jik + "</td>";
					str += "<tr>";
					count++;
				});
				
				str += "<tr><td colspan='3'>인원수 :" +count + "명 </td></tr>";
				str += "</table>";
				$("#showData").html(str);
				
			},
			error:function(){
				$("#showData").text("에러");
			}
		});
	}
</script>
</head>
<body>
	** 부서 정보(Spring @MVC)**</p>
	<table border="1">
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>전화</td>
		</tr>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:forEach var="bu" items="${blist }">
		<tr>
			<td>${bu.buser_no }</td>
			<td width="60"><a href="javascript:myfunc(${bu.buser_no })">${bu.buser_name }</a></td>
			<td>${bu.buser_tel }</td>
		</tr>
		</c:forEach>
	</table>
	<br />
	<div id="showData">...</div>
	<hr />
	방법1)
	<%
		String id = (String)session.getAttribute("idkey");
	%>
	<%=id %>님 환영합니다.
	<br />
	방법 2)
	${sessionScope.idkey } 님 환영합니다.
	${idkey } 님 환영합니다.
	<br />
	<a href="logout">로그아웃</a>
</body>
</html>