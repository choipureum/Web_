<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공</h1>
	<hr>
	<h3>로그인 상태 : ${login }</h3> <%--true, false 출력 --%>
	<h3>${loginid }님, 환영합니다</h3>
	<hr>
	<a href="/login/login">메인화면</a>
</body>
</html>
