<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie Confirm</h1>
	<hr>
	${cookie }<br>
	${cookie.PASS }<br> <!-- avax.servlet.http.Cookie@171660e -->
	${cookie.PASS.value }<br><!--1234  -->
	<hr>
	<!--ID=ALi
		PASS=1234
		NAME=alice  -->
	<% Cookie[] arr = request.getCookies();
	
		for(Cookie c:arr){ %>
			<%=c.getName() %>=<%=c.getValue() %><br>
		
<% }	%>

<hr>
<a href="/cookie/create"><button>쿠키 생성</button></a>
<a href="/cookie/update"><button>쿠키 수정</button></a>
<a href="/cookie/delete"><button>쿠키 삭제</button></a>

</body>
</html>
