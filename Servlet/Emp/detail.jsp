<%@page import="dto.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP 주석 --%>

<%-- 컨트롤러가 Request 객체에 저장해서 전달한 객체 꺼내기 --%>
<%	Emp e = (Emp) request.getAttribute("res"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원 상세 정보</h1>
<hr>
<table border="1">
<tr>
	<th>사원번호</th>
	<th>사원이름</th>
	<th>직무</th>
	<th>매니저</th>
	<th>입사날짜</th>
	<th>급여</th>
	<th>상여금</th>
	<th>부서번호</th>
</tr>
<tr>
	<td><%=e.getEmpno() %></td>
	<td><%=e.getEname() %></td>
	<td><%=e.getJob() %></td>
	<td><%=e.getMgr() %></td>
	<td><%=e.getHiredate() %></td>
	<td><%=e.getSal() %></td>
	<td><%=e.getComm() %></td>
	<td><%=e.getDeptno() %></td>
</tr>
</table>

</body>
</html>
