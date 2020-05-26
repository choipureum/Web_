<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello JSP!</h3>
	<%String name="Alice";
		System.out.println(name);%>
		<%--JSP 주석 --%>
		<!-- HTML 주석 -->
	<%--
		//자바 주석가능
	 --%>	
	<%String scripter="HI";
		System.out.println(scripter.length());
	%>
	<hr>
	<!-- out 키워드 -->
	<%out.print("브라우저 출력"); //out==resp.getWriter()%>
	<hr>
	<% for(int i=0;i<3;i++){ %>
		<h3>스크립트+HTML</h3>
	<% } %>
	<hr>
	<%
		//메소드 정의 불가
		//public void method(){}
		//접근 제한자를 이용한 변수 선언 불가
		//private int num=10;
	%>
	
	
		
</body>
</html>
