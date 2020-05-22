<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>inputForm</title>
</head>
<body>
<h1> 푸옥이</h1>
<hr>

<!-- doPost가 정의되어 있지않으면 버튼 클릭시 에러가 발생한다 -->
<form  action="/form.do" method="post">
	<label for="userid">아이디</label>
	<input type="text" id="userid" name="uid">

	<label for="userpw">비밀번호</label>
	<input type="text" id="'userpw" name="upw"><br></br>

	<input type="submit" value="로그인"/>
</form> 
</body>
</html>
