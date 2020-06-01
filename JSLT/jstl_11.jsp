<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fmt:formatDate</h1>
	<hr>
	<c:set var="now" value="<%=new Date() %>"/><br>
	now : ${now }<br><%--Mon Jun 01 18:00:58 KST 2020 --%>
	<hr>
	<%--2020. 6. 1 으로 출력 dateStyle은 설정안해줘도 default--%>	
	<%--short : 20. 6. 1
		medium : 2020. 6. 1
		long : 2020년 6월 1일 (월)
		full : 2020년 6월 1일 월요일 --%>
	default: <fmt:formatDate value="${now }" type="date" dateStyle="default"/><br>
	short : <fmt:formatDate value="${now }" type="date" dateStyle="short"/><br>
	medium : <fmt:formatDate value="${now }" type="date" dateStyle="medium"/><br>
	long : <fmt:formatDate value="${now }" type="date" dateStyle="long"/><br>
	full : <fmt:formatDate value="${now }" type="date" dateStyle="full"/><br>
	<hr>
	<%--default: 오후 6:08:20
		short : 오후 6:08
		medium : 오후 6:08:20
		long : 오후 6시 08분 20초
		full : 오후 6시 08분 20초 KST --%>
	default: <fmt:formatDate value="${now }" type="time" timeStyle="default"/><br>
	short : <fmt:formatDate value="${now }" type="time" timeStyle="short"/><br>
	medium : <fmt:formatDate value="${now }" type="time" timeStyle="medium"/><br>
	long : <fmt:formatDate value="${now }" type="time" timeStyle="long"/><br>
	full : <fmt:formatDate value="${now }" type="time" timeStyle="full"/><br>
	<hr>
	<%--날짜와 시간 둘다 보여주기 --%>
	<%--2020. 6. 1 오후 6:11:41 --%>
	<fmt:formatDate value="${now }" type="both"/><br> 
	<%--2020년 6월 1일 월요일 오후 6:11 : 둘다 따로따로 지정가능--%>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="short"/><br> 
	<hr>
	<%--2020-06-01 --%>
	yyyy-MM-dd : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/><br>
	<%--2020-06-01 18:14:25 오후 --%>
	yyyy-MM-dd HH:mm:ss a : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss a"/><br>
	
	<%--java.util.Date : 고정된(상수) 시간을 저장 --%>
	<%--java.util.Calendar : 지정된 시간저장, 저장된 시간을 변경할 수 있음 --%>
	
	<%--java.util.GregorianCalendar --%>
	<c:set var="testTime" value="<%=new GregorianCalendar(2020,5,1,12,5,8) %>"/>
	GregorianCalendar : ${testTime }<br> <%--엄청긴 이상한 toString값 출력 --> 볼수있는 형식으로 바꾸어줘야한다 --%>
	<c:set var="testTime" value="<%=new GregorianCalendar(2020,5,1,12,5,8).getTime() %>"/>
	GregorianCalendar : ${testTime }<br><%--Mon Jun 01 12:05:08 KST 2020   변환완료--%>
	<hr>
	<fmt:formatDate value="${testTime }" type="both"/><br><%--2020. 6. 1 오후 12:05:08 --%>
	KK: <fmt:formatDate value="${testTime }" pattern="KK"/><%--00시 --%>
	z: <fmt:formatDate value="${testTime }" pattern="z"/>
	Z: <fmt:formatDate value="${testTime }" pattern="Z"/>
	X: <fmt:formatDate value="${testTime }" pattern="X"/>
	<hr>
	
	<!-- 퀴즈 -->
	<!-- 기준 : 현재시간 -->
	<!-- 시간 1 : 2020-06-01 10:43:23 -->
	<!-- 시간 2 : 2020-05-12 15:13:57 -->
	<%--1. JSTL을 이용해서 풀기 --%>
	<%--jstl을 이용해서 오늘은 시:분으로 출력 --%>
	<%--jstl을 이용해서 오늘이전은  연월일으로 출력 --%>
	<%--현재 시간과 비교해서 출력 --%>
	<h1>퀴즈</h1>
	<hr>
	<h3>JSTL로 풀어보기</h3>	
	<%--시간 1, 시간2 Date 클래스로 만들기 --%><%--그레고리안 캘린더 써야작동(Date는 작동안됨) --%>
	<c:set var="time1" value="<%=new GregorianCalendar(2020,5,1,10,43,23).getTime() %>"/><br>	
	<c:set var="time2" value="<%=new GregorianCalendar(2020,4,12,15,13,57).getTime() %>"/><br>
	<%--현재시간 변수에 변환 --%>
	<fmt:formatDate value="${now }" pattern="yyyy-MM-dd" var="nowStr"/>
	<fmt:formatDate var="time1_1" value="${time1 }" pattern="yyyy-MM-dd"/>
	<fmt:formatDate var="time2_1" value="${time2 }" pattern="yyyy-MM-dd"/>
	
	<c:choose>
		<c:when test="${nowStr eq time1_1 }">
			<fmt:formatDate value="${time1 }" pattern="HH:mm"/><br>
		</c:when>
		<c:when test="${nowStr > time1_1 }">
			<fmt:formatDate value="${time1 }" pattern="yyyy-MM-dd"/><br>
		</c:when>
		</c:choose>
		
		<c:choose>
		<c:when test="${nowStr eq time2_1 }">
			<fmt:formatDate value="${time2 }" pattern="HH:mm"/><br>
		</c:when>
		<c:when test="${nowStr > time2_1 }">
			<fmt:formatDate value="${time2 }" pattern="yyyy-MM-dd"/><br>
		</c:when>			
	</c:choose>
	<br><br>
	
	<h3>표현식으로 풀어보기</h3>	
	<%--2. 표현식으로 풀어보기 --%> 
	 <% Date now = new Date();	   
	   Date time1 = new Date(2020,6,1,10,43,23);
	   Date time2 = new Date(2020,5,12,15,13,57);
	  //타임1 출력	 
		out.println("타임 1출력\n");
		   if(time1.getMonth()==now.getMonth()+1 && time1.getDate()==now.getDate()){
			   out.print(time1.getHours()+":"+time1.getMinutes()+"\n");
		   }else{
			   out.println(time1.getYear()+"-"+time1.getMonth()+"-"+time1.getDate()+"\n");
		   }		   
	  //타임 2 출력
	    out.println("타임 2출력");
		   if(time2.getMonth()==now.getMonth()+1 && time2.getDate()==now.getDate()){
			   out.print(time2.getHours()+":"+time2.getMinutes()+"\n");
		   }else{
			   out.println(time2.getYear()+"-"+time2.getMonth()+"-"+time2.getDate()+"\n");
		   }	
	%>
	<br><br><br><br><br>
</body>
</html>
