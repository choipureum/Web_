<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax_test</title>
<script type="text/javascript" src = "/resources/js/httpRequest.js"></script>

<script type="text/javascript">

window.onload = function(){
   
   //button#btnAction 태그에 click 이벤트 리스너 등록하기
   btnAction.onclick = function(){
//       console.log("btnAction clicked")

      //AJAX 요청 보내기
      sendRequest("POST","/ajax/test2","",callback);

   }
}

//ajax 응답 처리 콜백함수
function callback(){
   
   if(httpRequest.readyState ==4){ //XHR DONE
      if(httpRequest.status == 200){ //HTTP OK
         console.log("정상적인 ajax 응답 안료")
         
         printData();
      
      } else {
         console.log("ajax 요청/ 응답 실패")
      }
   }
   
}

//응답 결과 처리 함수
function printData(){
   console.log("printData called")
   
   console.log("--- responseText ----")
   
   console.log(httpRequest.responseText);
   
   result.innerHTML = httpRequest.responseText;
   
   
   
   

}
</script>
</head>
<body>

<h1>ajax 테스트</h1>
<hr>

<button id="btnAction">ajax 요청</button>

<div id="result"></div>


</body>
</html>
