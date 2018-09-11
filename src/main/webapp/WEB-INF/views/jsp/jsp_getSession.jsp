<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.*, java.util.*" %>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 가져오기</title>
</head>
<body>
<%
  String id=null;
  id = (String)session.getAttribute("session_id");
  out.println("이름:" + id + "<br>");
%>
</body>
</html>