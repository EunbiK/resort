<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String myName = "Hong.SJCU";
  Cookie cookieName = new Cookie("name", myName); //
  cookieName.setMaxAge(-1); //브라우저 켜있을때 까지
  response.addCookie(cookieName); //response객체에 보내야 사용가능함
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>쿠키 저장</title>
</head>
<body>
JSP 쿠키 사용
</body>
</html>