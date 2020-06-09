<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 새롭게 라이브러리화 시킨  AJAX 임포트 -->
<script type="text/javascript" src="/resources/js/httpRequest.js"></script>
<script type="text/javascript">

function ajaxToServer(){
	
	var params = "username=" + document.f.username.value; //username 인풋값 가져오기

	sendRequest("POST", "/ajax/ajax_03_ok.jsp",params,ajaxFromServer);	
}

//서버로부터 온 AJAX 응답을 처리하는 함수(콜백)
function ajaxFromServer(){
	
	if(httpRequest.readyState ==4){//정상응답
		if(httpRequest.status==200){
			console.log(httpRequest.responseText);
		}else{
		console.log("응답 에러")	
}
	}
}



</script>
<title>Insert title here</title>
</head>
<body>
	<h1>AJAX _03</h1>
	<hr>
	<form name="f">
		<input type="text" name="username">
		<button type="button" onclick="ajaxToServer();">입력</button>	
	</form>
</body>
</html>
