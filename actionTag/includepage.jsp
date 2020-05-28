<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
<h3>여기는 서브페이지</h3>
<p>include된 페이지 영역입니다</p>

<p>전달파라미터 : <%=request.getParameter("data") %></p>
<p>컨텍스트 : <%=request.getAttribute("requestData") %></p>
</div> 
