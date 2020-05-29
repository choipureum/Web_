<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>c:set</h1>
	<h3>세션 데이터 확인</h3>
	<hr>
	세션 데이터: ${sessionData }<br>
	<a href="./jstl_03.jsp">이전페이지</a><br>
	map 객체: ${m }
	<br>
	<%-- 아래와 같이 쓸수 있지만 잘 안쓰게됨 --%>
	<%
		out.print(((Map)request.getSession().getAttribute("m")).get("A"));
	%>
	<hr>
	User 객체 : ${sessionUser} <br>
</body>
</html>
