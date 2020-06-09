<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/httpRequest.js"></script>
<script type="text/javascript">
function send(){
	//전달 파라미터 구성
	var n= username.value;
	var c= content.value;
	
	var params="name="+n+"&content="+c;
	
	//url구성
	var url="/ajax/ajax_04_ok.jsp";
	
	//AJAX요청 전송 코드
	sendRequest("POST", url, params, callback);
}
//AJAX 요청 처리 콜백함수
function callback(){
	if(httpRequest.readyState ==4){ //XHR  DONE
		if(httpRequest.status ==200){
			//정상응답 처리함수
			appendResult();
		}else{
			//에러
		}
	}	
}
// 결과 <div>를 추가해주는함수
function appendResult(){
		//방법1
		// 직접<div>태그를 생성하고 응답값을 추가하고 div#result에 추가한다
		
		var newDiv = document.createElement("div");
		newDiv.innerHTML=httpRequest.responseText; //응답 데이터 추가
		result.appendChild(newDiv); //div#result의 자식요소로 추가
		
		//방법2
		//	방법1을 좀 더 축약(간단히)해서 작성하는 법
		result.innerHTML+="<div>"+httpRequest.responseText+"</div>";
		
		//방법3(**강추**)
		//	응답메세지에 <div>를 포함시키기
		//	ajax_04_ok 서버쪽에서 <div>등 형식 지정해서 보내주기!!-> 편함
		result.innerHTML += httpRequest.responseText;
}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>AJAX_04</h1>
	<hr>
	<!-- 이름, <input>태그 , id="username" -->
	<!-- 내용, <input>태그 , id="contemt" -->
	
	<!-- 이름, 내용 두가지의 데이터를 ajax_04_ok.jsp로 전송 -->
	<!-- 전송한 데이터를 이용하여 응답데이터로 작성 -->
	
	<!-- 형식
		<div> 
			name:Alice
			contetn: 안녕하세요!
			
			
			ALice 님 안녕하세요	
	 -->
	<!-- 응답받은 <div>데이터는 <button> 하단에 계속해서 추가되도록 만든다 -->
	
	<div>
		<label>이름 : <input type="text" id="username"></label><br>
		<label>내용 : <br><textarea id="content"></textarea></label><br>
		
		<button onclick="send();">전송</button>				
	</div>
	<div id="result"></div>
	
</body>
</html>
