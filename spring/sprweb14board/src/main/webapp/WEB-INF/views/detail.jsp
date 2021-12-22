<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="./resources/css/board.css" />
</head>
<body>
<h2>* 상세보기 *</h2>
<table>
	<tr>
		<td>비밀번호 : ${data.pass }</td>
		<td style="text-align: right">
			<a href="reply?num=${data.num }&page=${page}">
				<img src="./resources/images/reply.gif" alt="" />
			</a>
			<a href="update?num=${data.num }&page=${page}">
				<img src="./resources/images/edit.gif" alt="" />
			</a>
			<a href="delete?num=${data.num }&page=${page}">
				<img src="./resources/images/del.gif" alt="" />
			</a>
			<a href="list?page=${page}">
				<img src="./resources/images/list.gif" alt="" />
			</a>
		</td>
	</tr>
</table>

<table border="1">
	<tr>
		<td>작성자 : <a href="mailto:${data.mail }">${data.name }</a>
		(ip:${data.bip })</td>
		<td>작성일 : ${data.bdate }</td>
		<td>조회수 : ${data.readcnt }</td>
	</tr>
	<tr>
		<td colspan="3">제목 : ${data.title }</td>
	</tr>
	<tr>
		<td colspan="3">
			<textarea rows="10" style="width: 99%" readonly="readonly">${data.cont }</textarea>
		</td>
	</tr>
</table>
</body>
</html>