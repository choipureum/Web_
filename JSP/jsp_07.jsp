<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--에러 발생시 이동할 페이지 지정 --%>
 <%@ page errorPage="/basicTag/errorpage.jsp" %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러페이지테스트</h1>
	<hr>
	<%int num= 7/0;%>
</body>
</html>
