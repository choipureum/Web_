<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> c:out</h1>
<hr>

eldata: 	<c:out value="${eldata }"/><br>
empty eldata : <c:out value="${empty eldata }"/>
<hr>

<c:out value="null" default="null값을 출력함"/><br><%-- 문자열 null출력 --%>
<c:out value="${null}" default="null값을 출력함"/><br><%--null출력 --%>
<c:out value="${eldata}" default="null값을 출력함"/><br><%--null출력 --%>
<c:out value="<%=null %>" default="null값을 출력함"/><br><%--null출력 --%>
<c:out value="<h3>태그출력!</h3>"/> <%--innerText와 비슷한 동작 --%><%--html코드 적용 x ->일반 텍스트출력 --%>
<c:out value="<h3>태그출력!</h3>" escapeXml="false"/><br> <%--html형식 가능하게 됨 --%>
<%="<h3>태그 출력</h3>" %><%--inner:Html와 비슷한 동작 --%>
<%="&lt; h3&gt; 태그 출력 &lt;/h3&gt;" %> <%--h3출력하기위해서 --%>

&nbsp;
&laquo; <!--  <<  -->
&raquo; <!--  >> -->

&larr; <!--  <- -->
&rarr; <!--  ->  -->
<hr>
<% String str = "테스트 문자열"; %>
str 출력 : <c:out value="${str}"/><%--안됨 --%>
str 출력 : <c:out value="${pageScope.str}"/><%--안됨 --%>
str 출력 : <c:out value="<%= str %>"/><%--나옴 --%>
<%--스크립트릿은 JSTL의 속성값으로 적용되지 않는다 
	EL과 Exprssion을 주로 사용해야한다--%>

<hr>
<% request.setAttribute("str", str); //request컨테스트 영역에 추가%>
str 출력 : <c:out value="${str}"/>
str 출력 : <c:out value="${requestScope.str}"/>


</body>
</html>
