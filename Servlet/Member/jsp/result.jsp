<%@page import="java.util.List"%>
<%@page import="dto.Member"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--     pageEncoding="UTF-8"%> --%>
    
 <%	Member m = (Member) request.getAttribute("result"); %> 

 <!DOCTYPE html>
 <html> 
 <head>
 <meta charset="UTF-8"> 
 <title>회원가입 결과</title> 
 
</head> 
<h1>회원목록</h1> 
<hr> 
번호 : <%=m.getUserno() %><br>
아이디 : <%=m.getUserid() %><br>
닉네임 : <%=m.getNick() %><br>
이메일 : <%=m.getEmail() %><br>
 
<button onclick="location.href='/member/join'">회원가입페이지이동</button> 

 </body> 
 </html> 
