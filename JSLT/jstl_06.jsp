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
<hr>

<% 
   List<String> list = new ArrayList<>();
   
   list.add("Alice");
   list.add("b");
   list.add("c");
   list.add("d");
   list.add("e");



%>

<c:forEach var="iter" items="<%=list %>"
   begin="0" end="4" step="2"
   varStatus= "stat">
   
   <c:if test="${stat.first }">
   <span style="color:red; font-size:8px;">첫번째 반복입니다</span>
   </c:if>
   
   iter : ${iter}<br>
   반복 중 현재 인덱스 : ${stat.index }<br>
   반복 중 실행 횟수 : ${stat.count }   
   
   first:${stat.first }<br><%--처음 반복하는 곳이면 true 반환 --%>
   last: ${stat.last }<br><%--마지막 반복하는 곳이면 true 반환 --%>
   step: ${stat.step }   <br>

   <%--마지막에 경계선을 제거하는 코드  --%>
   <c:if test="${not stat.last }">
   -------------<br>
   </c:if>
   
   <c:if test="${stat.last }">
   <span style="color:red; font-size:8px;">마지막 반복입니다</span>
   </c:if>
</c:forEach>



</body>
</html>
