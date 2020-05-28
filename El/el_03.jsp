<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_03</title>
</head>
<body>

<h1>el 테스트 03</h1>
<h3>el의 컨텍스트 정보</h3>
<hr>


<%
   int localData = 100;
   
   pageContext.setAttribute("pageData", 200);
   request.setAttribute("requestData", 300);
   session.setAttribute("sessionData", 400);
   application.setAttribute("applicationData", 500);
   
   %>
   
   
<!--    java  영역(local scope)에 만들어진 변수를 el 로 참조할 수 없다 -->
localData : ${localData }<br>

<hr>
page : ${pageScope.pageData }<br>
request : ${requestScope.requestData }<br>
session :${sessionScope.sessionData }<br>
application :${applicationScope.applicationData }<br>
<hr>
<%--변수이름만 써도 적용됨 편함 --%>
<%--el의 컨텍스트 정보 내장객체들은 생략가능하다 
컨텍스트 정보를 page->request->session->application 순으로 찾는다--%>
page : ${pageData }<br>
request : ${requestData }<br>
session :${sessionData }<br>
application :${applicationData }<br>




</body>
</html>
