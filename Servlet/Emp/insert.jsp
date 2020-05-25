<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input {
	width: 150px;
}
label {
	display: inline-block;
	width: 80px;
}
</style>
</head>
<body>

<h1>신규 사원 등록</h1>
<hr>

<form action="/emp/insert" method="post">
	<label for="empno">사원번호</label>
	<input type="number" id="empno" name="empno"
	 min="1" max="9999" required="required" /><br>
	
	<label for="ename">사원이름</label>
	<input type="text" id="ename" name="ename" /><br>

	<label for="job">직무</label>
	<input type="text" id="job" name="job" /><br>
	
	<label for="mgr">매니저</label>
	<input type="number" id="mgr" name="mgr"
	 min="1" max="9999" /><br>

	<label for="hiredate">입사일자</label>
	<input type="date" id="hiredate" name="hiredate" /><br>
	
	<label for="sal">급여</label>
	<input type="number" id="sal" name="sal" /><br>
	
	<label for="comm">상여금</label>
	<input type="number" id="comm" name="comm" /><br>
	
	<label for="deptno">부서번호</label>
	<select id="deptno" name="deptno">
		<option value=""></option>
		<option value="10">ACCOUNT</option>
		<option value="20">RESEARCH</option>
		<option value="30">SALES</option>
		<option value="40">OPERATIONS</option>
	</select><br><br>
	
	<button>추가</button>

</form>

<hr>
<button onclick="history.go(-1)">뒤로 가기</button>

<hr>
<button onclick="location.href='/emp/list'">목록</button>

</body>
</html>










