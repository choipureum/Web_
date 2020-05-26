<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 선언은 !를 붙이면 선언가능 --%>
  <%! private int age=11; //접근제한자 사용가능%>
  
  
  <%! String name ="Alice"; %>
  <%! String hobby="Soccer"; %>
  
  <%! //메소드정의
  		public void method(){
	  	System.out.println("Hello "+name);
  }%>
  
  <%-- 메소드 호출 --%>
  <% method(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>
