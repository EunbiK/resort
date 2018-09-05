<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예약현황</title>
	</head>
	<body>
		<div><%@include file="top.jsp" %></div>
		<table border="1">
			<tr>
				<td>날짜</td>
				<td>합리적인룸</td>
				<td>일반룸</td>
				<td>VIP룸</td>
			</tr>
			
			<c:forEach items="${dateList}" var="date">
				<tr>
					<td>${date}</td>
					<td><a href=encodeURI("insertForm?type=resonable&date=${date}")> 예약가능 </a></td>
					<td><a href="insertForm?type=general&date=${date}"> 예약가능 </a></td>
					<td><a href="insertForm?type=vip&date=${date}"> 예약가능 </a></td>
				</tr>	
			</c:forEach>
		</table>
	</body>
</html>