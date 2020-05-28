<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>el 의 자료형</h1>
<hr>

정수형 : ${123 }<br>
실수형 : ${123.43 }<br>
단일문자 : ${'A' }<br>
문자열 : ${"apple" }<br>
논리형 : ${true }&nbsp;&nbsp;&nbsp;${false }<br>
null : ${null }<br>
<!-- null 은 출력하면 아무것도 안나온다 -->

<h1>el의 연산자</h1>

${123 eq 123 }<br>

${10 >20 }<br>
${10 gt 20 }<br>

${10 / 4}<br>
<%-- ${10 div 4 }<br> --%>
<!-- 위에 문장은 원래 에러가 나옴 -->

str : ${str }<br>
empty str : ${empty str }<br>
<hr>
${str="banana" }<br>
${str } <%--banana  출력 --%>
<hr>
<% int num= 333; //java영역에 선언된 변수%>
<h3>자바 영역의 변수를 EL로 출력하기 </h3>
num: ${num }<br> <%-- num값은 다르다 -> 그냥 문자열 num출력 --%>
empty num : ${empty num }<br> 
<%-- EL을 자바 영역의 변수를 사용하지 못한다 --%>
<hr>	
<% pageContext.setAttribute("num", num); //pageContext영역에 변수 저장 %>
<h3> 자바 변수를 컨텍스트 영역에 넣고 EL로 출력하기</h3>
num: ${num }<br>
empty num : ${empty num }<br> 
<hr>
${data="cherry" }<br>
<% //EL에서 선언된 변수는 page context 영역 scope에 저장된다 
String d =(String)pageContext.getAttribute("data"); 
	out.print(d);
%>

</body>
</html>

