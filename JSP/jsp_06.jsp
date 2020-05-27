<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--jsp를 include영역으로 헤더 푸터를 지정해서 고정으로 표시할 수 있다 --%>
<%@ include file="/basicTag/header.jsp" %>
<style>
h1{
 color:tomato;
 /*include를 해준 h1도 모두 적용되버린다*/
}
/*적용될 부위에만 적용*/
#myDiv h1{
	color:blue;
}
</style>
<!-- 해당페이지에만 적용될 자바스크립트 문 -->
<script type="text/javascript">
</script>
<!-- 주의사항 -->
<!-- header.jsp 에서 추가한 JS, CSS와 충돌나지 않게 특히 라이브러리 (Jquery)관리에 신경써야함 -->

<div id="myDiv">
	<h1>또다른 페이지의 내용</h1>
	<h3>내용영역!</h3>
</div>   
<%@ include file="/basicTag/footer.jsp" %>
