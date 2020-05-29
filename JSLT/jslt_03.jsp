<%@page import="java.util.*"%>
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

<h1>c:set</h1>
<hr>

<%--세션 컨텍스트 정보 삽입 --%>
<c:set var="sessionData" value="SESSION_DATA_123123" />

<a href="./jstl_03_session.jsp">세션확인</a>
<hr>
<% Map map = new HashMap(); %> <%-- 자바 영역 --%>
map:  ${map }<br><br><%-- Context영역 을 찾음 - 안나옴 --%>
<%--JSTL을 이용한 Map객체의 프로퍼티 삽입(map.put(key,value) --%>
<c:set target="<%=map %>" property="A" value="Alice"/>
<c:set target="<%=map %>" property="B" value="Bob"/>

A key : <%=map.get("Alice") %><br>
<%--JSTL을 이용한 session 컨텍스트 정보로 등록하기 --%>
<c:set var="m" value="<%=map %>" scope="session" />
B key : ${m.B} <br>
B key : ${m} <br>

<hr>
<jsp:useBean id="userBean" class="dto.User"/><%--자바영역과 컨텍스트영역 에 둘다 생성된다 --%>
<%--자바빈의 프로퍼티에 값 넣기 --%>
<jsp:setProperty property="id" name="userBean" value="AAA"/>
<c:set target="${userBean }" property="pw" value="BBB"></c:set>
${userBean} <br>

<%-- jstl을 이용해서 자바빈 userBean 을 세션정보로 등록하기 --%>
<c:set var="sessionUser" value="${userBean }" scope="session"/><%--<%=userBean 해도됨 --%>

<hr>
<%-- 모든 컨텍스트 영역에서 "sessionData"로 등록된 변수 제거 --%>
<c:remove var="sessionData"/>
<%-- 세션 컨텍스트 영역에서 "sessionData"로 등록된 변수 제거 --%>
<c:remove var="sessionData" scope="session"/>

<% session.removeAttribute("sessionData"); %>

</body>
</html>
