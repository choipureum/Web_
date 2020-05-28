<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/basicTag/header.jsp"/>
<h1> 액션태그 테스트</h1>
<h3>include</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %><%--한글인코딩 --%>
<% request.setAttribute("requestData", "하하하하");%>
<jsp:include page="/actionTag/includePage.jsp"> <%--끝에 />하면 안된다 계속 이어진다면 --%>
	<jsp:param value="안녕!" name="data"/>
	</jsp:include>
<jsp:include page="/basicTag/footer.jsp"/>

