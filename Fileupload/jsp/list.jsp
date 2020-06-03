<%@page import="dto.UploadFile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid #ccc;
}
td {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	
	padding: 5px 10px;
}
td:hover {
	background: #FAFAD2;
}
</style>

</head>
<body>
	<h1>FILE 리스트</h1>
	<hr>
	<table>
		<tr>
			<th>파일번호</th>
			<th>원본이름</th>
			<th>저장된이름</th>
		</tr>
		
		<c:forEach items="${list }" var="i">
		<tr>
			<td>${i.fileno }</td>
			<td>${i.originName }</td>
			<td>${i.storedName }</td>
		</tr>
		</c:forEach>
		
		</table>
		<button onclick="location.href='/commons/fileupload'">뒤로가기</button>
</body>
</html>
