<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>actiontag_02</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<h3>forward</h3>
<hr>

<jsp:forward page="./actionTag_03.jsp">
   <jsp:param value="Alice" name="nick"/>
</jsp:forward>


</html>
