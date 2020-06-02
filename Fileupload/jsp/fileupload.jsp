<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 Form</h1>
	<h3>Commons Fileupload</h3>
	<hr>
	<!--enctype을 기본값에서 변환해주어야 파일업로드를 사용할 수 있다  -->
	<form action="/commons/fileupload" method="post" enctype="multipart/form-data">
		<label>제목 : <input type="text" name="title"/> </label><br>
		<label>데이터1 : <input type="text" name="data1"/> </label><br>
		<label>데이터2 : <input type="text" name="data2"/> </label><br><br>
		<label>파일 : <input type="file" name="upfile"/></label><br><br>
		<button>전송</button>
	</form>
</body>
</html>
