<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 02</title>

<script type="text/javascript">

// ajax객체인 xhr을 생성하는 함수 - 크로스 브라우징 처리 
function createXMLHttpRequest() {
   // XHR 객체 변수
   var xmlReq = null;
   
   if( window.XMLHttpRequest) { //SMLHttpRequest 객체가 존재한다면
      //IE 7.0이상일때
      //IE 브라우저가 아닐 때(크롬, 사파리, 오페라 등등)     
      xmlReq = new XMLHttpRequest();
   
   } else if( window.ActiveXObject) {      
      try{
         //비교적 최근 버전의 IE
         xmlReq = new ActiveObject("Msxml2.XMLHTTP");
      } catch(e1){         
         try{
            //비교적 에전 버전 IE
            xmlReq= new ActiveObject("Microsoft.XMLHTTP")           
         } catch(e2){
            // XHR이 없는 경우엔 수행할 수 없음
            console.log("AJAX 객체 생성 실패")
         }
      }
   }
   return xmlReq;   
}
</script>


<script type="text/javascript">

//AJAX 객체 변수 - XHR
var xmlHttp = null;

function send(){
   console.log("send called")
   
   //xHR 객체 생성
   // AJAX 수행 객체 생성하기
   
   xmlHttp = createXMLHttpRequest();
   
    console.log(xmlHttp);

   //입력한 데이터 구하기 - 전송 데잍어 만들기
   var n1 = num1.value;
   var n2 = num2.value;
   var op = oper.value;
   
   //확인 콘솔 출력
//     console.log(n1);
//     console.log(n2);
//     console.log(oper);

   //AJAX 요청 전 설정  	
   //요청 URL
   	var query ="num1="+n1+"&num2="+n2+"&oper="+op; //쿼리스트링 작성
 	var url = "/ajax/ajax_02_ok.jsp"+"?"+query;//전송 url 작성
// 	console.log(url);
 	
   	//요청 Method
   var method="GET";
   	
   //서버로부터 전달된 응답 데이터 처리 콜백함수
   xmlHttp.onreadystatechange= callback;
   
   // - - - - - - - - - - - - - - 
   
   //---Ajax 요청 전 준비
   //XHR 객체가 서버로 통신할 준비를 함 - 서버로 접속함(통신스트림)
   xmlHttp.open(method,url);
   
   //---Ajax 요청 보내기
   //XHR객체가 서버로 요청메세지를 전송함
   //	-> 사버로 데이터 전송
   xmlHttp.send(null); 
}
function callback(){
	console.log("callback");
	
	if(xmlHttp.readyState ==4 ){	//readyState 4 , Done, 응답완료
		if(xmlHttp.status == 200 ){ //OK(정답 응답)
			console.log("정상 응답");
			//응답 처리 결과 전용 함수
			printData();
		}else if(xmlHttp.status == 404){ //NOT FOUND
			console.log("페이지 없음");
		}else if(xmlHttp.status == 405){ //Method Now Allowed
			console.log("HTTP method 처리 불가");
		}else if(xmlHttp.status == 500){ //Internal Server Error
			console.log("서버 에러");
		}else{
			console.log(xmlHttp.statusText); //위에 안해줘도 영어로 이렇게 표시 가능
		}
	}	
}
//응답 처리 함수
function printData(){
//	console.log("printData");
	
	//div#resultLayout에 결과반영하기 
	resultLayout.innerHTML = xmlHttp.responseText;
	
				
}
</script>
</head>
<body>

<h1>계산기 02</h1>
<h3>ajax 통신( 비동기식 )</h3>
<hr>


<input type = "text" id="num1" />
<select id="oper">
      <option value="add">더하기</option>
      <option value="sub">빼기</option>
      <option value="mul">곱하기</option>               
      <option value="div">나누기</option>      

</select>
<input type="text" id= "num2" />

<button onclick="send();"> = </button>

<hr>

<!-- ajax요청의 결과(응답)이 추가될 div -->
<div id = "resultLayout"></div>


</body>
</html>
