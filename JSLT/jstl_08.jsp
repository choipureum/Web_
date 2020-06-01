<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="/basicTag/header.jsp"/>

<h1>c:import</h1>
<hr>

   
<%-- <<c:import url="https://www.naver.com"/> --%>


<%-- <c:import url="https://www.youtube.com"/> --%>
<!-- 유투브같은 막혀있는 사이트는 iframe을 이용 -->
<!-- <iframe width="560" height="315" src="https://www.youtube.com/embed/4WMwE7W_Cpw" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->
<hr>
<%--name과 value 현금으로 검색된 페이지로 이동 --%>
<c:import url="https://search.naver.com/search.naver">
   <c:param name="query" value="현금"/>
</c:import>

<hr>
<c:redirect url="https://www.google.com"/>

<c:import url="/basicTag/footer.jsp"/>
