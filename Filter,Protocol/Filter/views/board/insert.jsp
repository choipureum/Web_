<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원가입 Form 입력페이지</h1>
	<hr>
	<form action="<%=request.getContextPath() %>/board/insert" method="post">
		<label>아이디 : <input type="text" name="uid"/></label><br>
		<label>비밀번호 : <input type="text" name="upw"/></label><br>
		<button>가입</button>
	</form>
</body>
</html>
