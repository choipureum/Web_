<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/resources/js/httpRequest.js"></script>
<script type="text/javascript">
	window.onload=function(){			
	//#btnAction 태그에 click 이벤트 리스너 등록하기
	btnAction.onclick = function(){
		console.log("btnAction click");
		sendRequest("POST","/ajax/test","",callback);
		}
	}
	
function callback(){
		if(httpRequest.readyState ==4){ //XHR DONE
			if(httpRequest.status==200){ //HTTP OK
				console.log("정상적인 AJAX 요청/응답 완료");
				printData();
				
			}else{
				console.log("AJAX요청/응답 실패");
			}
		}
	}		
	
function printData(){
	console.log("printdata 출력");
	var respText = httpRequest.responseText;
	//응답받은 JSON 데이터 언마샬링(JSON Object로 변환)
	var jsonObject = JSON.parse(respText);

	for(var i=0;i<jsonObject.length;i++){
		result.innerHTML+="<div>"+jsonObject[i].id + " : " +jsonObject[i].pw + "</div>"
		
	}

}


</script>
</head>
<body>
	<h1>Ajax Test</h1>
	<hr>
	
	<button id="btnAction">AJAX요청</button>
	<!-- 여기에 추가 -->
	<div id="result"></div>
	
	
	
</body>
</html>
