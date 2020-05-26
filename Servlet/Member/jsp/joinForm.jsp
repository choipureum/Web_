<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form method="post" action="/member/join">
	<label for="userid">아이디 : </label>
	<input type="text" id="userid" name="userid"><br><br>
	
	<label for="nick">닉네임 : </label>
	<input type="text" id="nick" name="nick"><br><br>
	
	<label for="email">이메일: </label>
	<input type="email" id="email" name="email"><br><br>
	<button>회원가입</button>
	</form>
	
</body>
</html>
