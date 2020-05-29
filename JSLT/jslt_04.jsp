<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>c:if</h1>
	<hr>
	<c:if test="true">
		<h3>무조건 실행</h3>
	</c:if>
	
	<c:if test="false">
		<h3>무조건 실행하지 않음</h3>
	</c:if>
	<hr>
	<c:if test="단순문자열">
		<h2>문자열 반복문</h2>
	</c:if><%-- 안됨 true나 false만 처리해야함 문자는 --%>
	<c:if test="${10 eq 10 }">
		<h3> 10 eq 10</h3>
		</c:if> <%--출력됨 --%>
		<%--속성 값으로 빈칸이 들어가면 안됨! 주의할 것 --%>
	<hr>
	<%--서블릿 Controller에서 DB조회 결과를 모델값으로 전달했음 --%>
	<%--request컨텍스트 영역 사용함--%>
	<% request.setAttribute("userList", null);//조회된 결과가 없음,null %>
	<c:if test="${empty userList }">
	<h3>조회된 데이터가 없습니다</h3>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		<tr>
			<td>${userList[0].id }</td>
			<td>${userList[0].pw }</td>
		</tr>	
	</table>
	</c:if>	
</body>
</html>
