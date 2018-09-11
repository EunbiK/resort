<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.*, java.util.*" %>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션정보 파괴하기</title>
</head>
<body>
<%session.invalidate();
  out.println("세션종료");%>
</body>
</html>