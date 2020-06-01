<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fmt:formatNumber</h1>
	<hr>
	<fmt:formatNumber value="1234567890" /><br>
	<fmt:formatNumber value="1234567890" type="number"/><br> <!-- 똑같 -->
	<fmt:formatNumber value="1234567890" type="currency"/><br><!-- (원)숫자 -->
	<fmt:formatNumber value="1234567890" type="percent"/><br><!-- 숫자% -->
	
	<hr>
	
	<fmt:formatNumber value="1234567890" type="number" groupingUsed="false"/><br><!-- 숫자를 구분하는 ,(comma)가 사라짐 -->
	<fmt:formatNumber value="1234567890" type="currency" currencySymbol="$"/><br><!-- 통화기호가 원이 아니라 currencySymbol속 문자열로 붙음 -->
	<!-- minFractionDigits 소수점 자릿수 지정 -->
	<fmt:formatNumber value="1234567890" type="currency" currencySymbol="$" minFractionDigits="2"/><br><!-- 소수점 뒤에 2자리 유지 -->
	<!-- minIntegerDigits 정수 자릿수 지정 -->
	<fmt:formatNumber value="7" type="currency" currencySymbol="$" minIntegerDigits="5"/><br><!-- 정수부분을 0을채워서 자리유지 (더 큰숫자는 안됨) -->
	
	<hr>
	<fmt:formatNumber value="12345.60" type="currency" currencyCode="USD"/><br><!-- USD 12346출력(자동 반올림) -->
	<fmt:formatNumber value="12345.60" type="currency" currencyCode="JPY"/><br>
	
	<hr>
	<fmt:formatNumber value="12345.67890" type="number" pattern="#####.#"/><br> <!-- groupingUsed=true가 고정값이지만 패턴은 콤마를 넣지않는한 나오지않음 -->
	<fmt:formatNumber value="12345.67890" type="number" pattern="###,###,###.###"/><br>
	<hr>
	
	<fmt:formatNumber value="12345.67890" type="number" pattern="000000000.000"/><br><!-- 없는 자리에 0이 들어감 -->
	<!-- 정수부 자리+소수점 3자리 유지 --><%--패턴으로 다해도됨 --%>
	<fmt:formatNumber value="12345.67890" type="number" pattern="USD#,###.000"/><br>
	
	
</body>
</html>
