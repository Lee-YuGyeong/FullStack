<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step07</title>
</head>
<body>

	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
	
		let str="i am gura";
		let str2="i like friday and saturday and sunday";
		//str 에서 단어만 추출해서 배열에 담으려면?
		//단어란? 공백이 아닌 한글자가 한번이상 반복 되는 것이다 ?
		let reg=/[\S]+/g;   
		/*
		   [ ] => [\s]
		   [^ ] => [^\s] => [\S] 
		*/
		//str 문자열에서 단어만 찾아서 배열에 담아오기 
		let result = str.match(reg);   
		//str2 에서 요일에 해당하는 단어만 추출해서 배열에 담으려면?
		let reg2=/[\S]+day/g;
		/*
		   문자열로 정규표현식을 작성할때 역슬레시는 하나가 필요하면 2개씩 작성해야 한다.
		   
		   /[\w]/   =>  "[\\w]"
		   
		   /\^abc/  => "\\^abc"
		   
		   /\\abc/  => "\\\\abc"
		   
		*/
		let reg3=new RegExp("[\\S]+day","g");
		let result2 = str2.match(reg2);
		let result3 = str2.match(reg3);
		
		let str3="hello, hello, juli!";
		//str3 문자열에서 hello 를 hi 로 바꾸기
		let result4 = str3.replace(/hello/g, "hi");
		
		let str4="HELLO, hello, juli!";
		//str4 문자열에서 HELLO 혹은 hello 를 hi 로 바꾸기 (대소문자를 구별하지 않겠다)
		let result5=str4.replace(/hello/gi, "hi");
	</script>
</body>
</html>