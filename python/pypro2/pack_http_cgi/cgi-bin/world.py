s1 = '자료1'
s2 = '데이터2'

print('Content-Type:text/html;charset=utf-8\n')
print("""
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>world 문서</h1>
자료 출력 : {0} {1}
<br>
<img src='../images/logo.png'>
<br>
<a href="../index.html">메인 페이지</a>
</body>
</html>
""".format(s1,s2))