<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/el/test01.jsp</title>
</head>
<body>
   <h1>Expression Language 테스트 (EL)</h1>
   <p>jsp 페이지에서 특별하게 해석되는 코드 블럭</p>
   <p>EL 영역은 &#36;{ } 로 만들수 있습니다.</p>
   
   <h2>산술연산</h2>
   <p>1+1 = ${1+1 }</p>
   <p>10-1 = ${10-1 }</p>
   <p>10*10 = ${10*10 }</p>
   <p>10/3 = ${10/3 }</p>
   
   <h3>비교연산</h3>
   <p>10 &gt; 2 : ${10 > 2 }</p>
   <p>10 &gt; 2 : ${10 gt 2 }</p>
   <p>10 &ge; 2 : ${10 >= 2 }</p>
   <p>10 &ge; 2 : ${10 ge 2 }</p>
   
   <p>10 &lt; 2 : ${10 < 2 }</p>
   <p>10 &lt; 2 : ${10 lt 2 }</p>
   <p>10 &le; 2 : ${10 <= 2 }</p>
   <p>10 &le; 2 : ${10 le 2 }</p>
   
   <p>10 == 10 : ${10 == 10 }</p>
   <p>10 == 10 : ${10 eq 10 }</p>
   <p>10 != 10 : ${10 != 10 }</p>
   <p>10 != 10 : ${10 ne 10 }</p>
   
   <h2>논리연산</h2>
   <p> true || false : ${true || false }</p>
   <p> true or false : ${true or false }</p>
   <p> true && false : ${true && false }</p>
   <p> true and false : ${true and false }</p>
   <p> !true : ${!true }</p>
   <p> not true: ${not true }</p>
   
   <h3>삼항 연산</h3>
   <p>성별: ${ false ? '남자임' : '여자임' }</p>
   
   <h2>empty 연산자 (값이 비어 있는지 여부를 판정해 준다)</h2>
   <p> null 혹은 빈 문자열("") 을 비어(empty) 있다고 판정해 준다.</p>
   <p> empty null : ${empty null }</p>
   <p> empty "" : ${empty "" }</p>
   <p> not empty null : ${not empty null }</p>
   <p> not empty "" " ${not empty "" }</p>      
   
   <p> empty "kimgura" : ${empty "kimgura" }</p>
   <p> empty 999 : ${empty 999 }</p>
</body>
</html>







