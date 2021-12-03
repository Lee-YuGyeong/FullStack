<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jquery/Step07</title>
</head>
<body>
	<input type="text" id="one" />
	<button id="checkBtn1">검증</button>
	<p>첫글자는 영문자 시작하고 최소 5글자 최대 10글자 이내로 입력하세요</p>
	
	<input type="text" id="two" />
	<button id="checkBtn2">검증</button>
	<p>특수문자는 허용하지 않습니다</p>
	
	<input type="text" id="three" />
	<button id="checkBtn3">검증</button>
	<p>이메일 형식에 맞게 입력하세요</p>
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$("#checkBtn1").click(function(){
			//input 요소에 입력한 문자열 읽어와서 str 이라는 이름의 변수에 담기
			let str=$("#one").val();
			let reg=/^[a-zA-Z].{4,9}$/;
			let isMatch=reg.test(str);
			if(isMatch){
				alert("매칭됩니다.");
			}else{
				alert("매칭이 되지 않습니다.");
			}
			
		});
		
		$("#checkBtn2").on("click", function(){
			let str=$("#two").val();
			let reg=/^[a-zA-Z0-9]+$/;
			let reg2=/^[\w]+$/;
			if(reg.test(str)){
				alert("매칭됩니다.");
			}else{
				alert("특수문자는 허용하지 않습니다.");
			}
			let reg3=/[^a-zA-Z0-9]+/; //특수문자를 찾는 정규 표현식
			let reg4=/[\W]+/; //특수문자를 찾는 정규 표현식
			
			if(reg3.test(str)){//특수문자가 최소 하나이상 포함되어 있는경우 true
				alert("특수문자는 허용하지 않습니다.");
			}else{
				alert("매칭됩니다.");
			}
		
		}); 

	
		$("#checkBtn3").on("click", function(){
			let str=$("#three").val();
			let reg=new RegExp("^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$");
			if(reg.test(str)){
				alert("메칭됩니다.");
			}else{
				alert("이메일 형식에 맞게 입력 하세요.");
			}
		});

	</script>
</body>
</html>