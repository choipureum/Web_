<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--현재 JSP페이지에서 에러처리할 수 있도록 만듬 --%>
 <%--exception키워드 (객체) 사용가능 --%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:red">에러페이지입니다</h1>
	<hr>
	<h3>에러 내용</h3>
	<%=exception.getMessage() %><br><br>
	<%=exception.toString() %>
</body>
</html>
