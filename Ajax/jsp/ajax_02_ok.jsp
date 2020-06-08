<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>    
   <%-- 여기는 전체 코드를 적어주면 안된다 --%> 
<c:set var="n1" value="${param.num1 }"/>
	<c:set var="n2" value="${param.num2 }"/>
	<c:set var="op" value="${param.oper }"/>
	
	<%--계산기 로직 JSTL --%>
	<c:choose>
		<c:when test="${op eq 'add' }">
			${n1 } + ${n2 } = ${n1+n2 }<br>
		</c:when>
		
		<c:when test="${op eq 'sub' }">
			${n1 } - ${n2 } = ${n1-n2 }<br>
		</c:when>
		
		<c:when test="${op eq 'mul' }">
			${n1 } * ${n2 } = ${n1*n2 }<br>
		</c:when>
		
		<c:when test="${op eq 'div' }">
			${n1 } / ${n2 } = ${n1/n2 }<br>
		</c:when>
	</c:choose>
