<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {																			
   text-align: center;/* 가운데 정렬 */
}

div.result {}

div [id^=res] {
   border: 1px solid #ccc;
   width: 100px;
   display: inline-block;
   margin: 0 5px;
   padding: 5px 0;
}

div [id^=res]:hover {
   background: skyblue;
}

#gugudan {
   min-width: 960px;
}

</style>
</head>
<body>

<h1>c:forEach</h1>
<hr>

<%-- step 속성을 적지 않으면 기본값 1 --%>
<c:forEach var="i" begin="1" end="10">
   <h3>${i }</h3>
</c:forEach>

<hr>
<%-- 1~100까지의 합 구하기 --%>
<c:set value="total" var="0" />

<c:forEach var="i" begin="1" end="100" step="1">
   <c:set var="total" value="${total + i }" />   
</c:forEach>

<h3>1~100의 합 : ${total }</h3>

<hr>

<h3>구구단</h3>

<%-- 2~9단 --%>

<div id="gugudan">
<c:forEach var="i" begin="1" end="9" >
   
   <div>
   <c:forEach var="j" begin="2" end="9">
      
      <div class="result" id="res${j }${i}">
      <c:out value="${j } * ${i } = ${i*j } " />
      </div>
      
   </c:forEach>
   </div> 
</c:forEach>
</div>




</body>
</html>
