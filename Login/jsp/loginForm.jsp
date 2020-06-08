<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 폼</h1>
	<hr>
	<!-- 로그인이 안됫을때 -->
	<c:if test="${empty login }"><%--login==null인지 검사(비로그인상태) --%>
		<form action="/login/login" method="post">
		
		<label for="userid">ID</label>
		<input type="text" id="userid" name="userid"/><br>
		
		<label for="userpw">PW</label>
		<input type="text" id="userpw" name="userpw"/><br>
		
		<button type="submit">로그인</button> <!-- submit 으로 처리 -->	
		</form>
	</c:if>
	<c:if test="${not empty login }">
		<!-- 로그인되었을때 로그아웃 버튼 -->
		<!-- c:if를 위해서 form태그 바깥에서 처리한다 -->
		<!-- 로그아웃도 누르면 제출처리 -> 버튼으로 바꾼다 -->
		<button type="button" onclick="location.href='/login/logout'">로그아웃</button>
	</c:if>
</body>
</html>
