<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/httpRequest.js"></script>

<script type="text/javascript">
//t
function send(){
//    console.log("send called")
   var n= username.value;
   var c = content.value;
   
   var params = "username="+n+"&content="+c;
   //---------------------------
   //------------URL구성-------------
   var url = "/ajax/ajax_05_ok.jsp";
   //--------------------------
   
   //------------ajax요청전송---------------
   sendRequest("POST",url,params,callback);
   
}
//AJAX 요청처리 콜백함수
function callback(){
   if(httpRequest.readyState == 4){ //XHR DONE.
      if(httpRequest.status == 200){
         console.log("정상적인 응답")
         appendResult();
         
      }else{
         console.log("AJAX 요청 / 응답 에러")
      }
      
   }
   
}
   //결과를 <div>를 추가해주는 함수
 function appendResult(){
    console.log("appendResult called")
   
    console.log("----responseText-----")
    console.log(httpRequest.responseText)
    console.log("----responseXML-----")
    console.log(httpRequest.responseXML)
      //XML 데이터를 추출하기 (파싱 , Parsing)
       //XML Document 객체에는 getElementById("idname") 을 사용할 수 없다
       
       // getElementsByTagName("tagname")을 사용해야 한다
       
       // 응답받는 XML 데이터
      var resultData = httpRequest.responseXML;
       console.log(resultData);
      //member태그 객체얻기 - 배열로 반환함
      var member = resultData.getElementsByTagName("member");
       console.log(member[0]);
       
       //record태그 객체 얻기 - 배열로 반환함
       var record = member[0].getElementsByTagName("record");
       
       //name태그 , content태그 객체얻기- 배열로 반환함
       var name=  record[0].getElementsByTagName("name");
       var content=  record[0].getElementsByTagName("content");
       
       //태그의 자식 텍스트 데이터 꺼내기
       var nameData = name.firstChild.nodeValue; 
	   var contentData = content.firstChild.nodeValue;	 		
		   
	   	//div#result에 <div>추가하기
   		result.innerHTML+="<div>"+nameData+" , "+contentData+"</div>";
   		
}

</script>
</head>
<body>
<h1>AJAX 04</h1>
<hr>


<div>
<label>이름 <input type="text" id="username"></label><br>
<label>내용 <input type="text" id="content"></label><br>
<button onclick ="send();">전송</button>
</div>
<div id="result">

</div>


</body>
</html>
