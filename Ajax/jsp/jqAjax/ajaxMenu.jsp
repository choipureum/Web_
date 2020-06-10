<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("a").click(function(){
		console.log("a태그클릭됨");
		
		//클릭 이벤트가 발생한 <a>태그의 href속성을 .load()함수의 url로 사용
		$(".right").load($(this).attr("href"));
		
		
		
		
		//<a>태그의 기본동작 막는다
		return false;
		
		//**이벤트 리스너에서 return false;를 실행하면
		// 이벤트의 기본 동작(동적처리)를 막는다
	});
})


</script>
<!-- Ajax메뉴 처리방식 -->
<style type="text/css">
.left{
	float:left;
	width:30%;
	height:600px;
	background:#ccc;
}
.right{
	float:right;
	width:65%;
	height:600px;
	background:#ffc;
}
</style>
</head>
<body>
	<h1> Ajax menu</h1>
	<hr>
	<div class="left">
		<a href="/ajax/ajax_01.jsp">AJAX01</a><br>
		<a href="/ajax/ajax_02.jsp">AJAX02</a>	<br>
		<a href="/ajax/ajax_03.jsp">AJAX03</a>	<br>
	</div>	
	<div class="right"></div>
</body>
</html>
