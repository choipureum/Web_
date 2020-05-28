<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워딩된 페이지</title>
</head>
<body>

<h3>포워딩된 페이지</h3>
<hr>

nick : <%=request.getAttribute("nick") %><br>
nick : <%=request.getParameter("nick") %><br>


</body>
</html>
