<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@page import="java.net.URLEncoder"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예약현황</title>
		<link rel="stylesheet" href="./css/main.css" type="text/css">
	</head>
	<body>
		<div><%@include file="top.jsp" %></div>
		<div class="main">
			<div class="introduce">
				<table width="600" border="1" cellpadding="3px" cellspacing="0">
					<tr align="center">
						<td>날짜</td>
						<td>합리적인룸</td>
						<td>일반룸</td>
						<td>VIP룸</td>
					</tr>
					
					<c:forEach items="${dateList}" var="date" varStatus="status">
						<tr align="center">
							<td>${date}</td>
							<td><c:choose>
									<c:when test="${resonableGroup.get(status.index).size() ne 0}">	
										<a href="insertForm?type=resonable&date=${date}"> 예약가능 </a>
									</c:when>
									<c:otherwise>예약불가</c:otherwise>
								</c:choose>								
							</td>
							<td><c:choose>
									<c:when test="${generalGroup.get(status.index).size() ne 0}">	
										<a href="insertForm?type=general&date=${date}"> 예약가능 </a>
									</c:when>
									<c:otherwise>예약불가</c:otherwise>
								</c:choose>								
							</td>
							<td><c:choose>
									<c:when test="${vipGroup.get(status.index).size() ne 0}">	
										<a href="insertForm?type=vip&date=${date}"> 예약가능 </a>
									</c:when>
									<c:otherwise>예약불가</c:otherwise>
								</c:choose>								
							</td>
							<%-- <td><a href="insertForm?type=general&date=${date}"> 예약가능 </a></td>
							<td><a href="insertForm?type=vip&date=${date}"> 예약가능 </a></td> --%>
						</tr>	
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>