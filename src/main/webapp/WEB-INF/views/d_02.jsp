<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@page import="java.net.URLDecoder"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예약화면</title>
	</head>
	<body>
		<div><%@include file="top.jsp" %></div>
		<div>
			<form name=movement method="POST">
				<table border="1" width="700" cellspacing="0" cellpadding="3">
					<tr>
						<td width="100" align="center">성명</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td align="center">예약일자</td>
						<td><c:choose>
									<c:when test="${empty all}">
										<input type="text" name="time" value="${reservation.time }" style="border:0" readonly >
									</c:when>
									<c:otherwise>
										<select name="selectDate">
											<option value=""selected disabled hidden>예약일자 선택</option>
											<c:forEach items="${dateList }" var="date">
												<option value="${date}">${date}</option>
											</c:forEach>
										</select>
									</c:otherwise>
								</c:choose>
							
						
						</td>
					</tr>
					<tr>
						<td align="center">예약방</td>
						<td><select name="roomId">
								<c:choose>
									<c:when test="${empty all}">
										<option value=""selected disabled hidden>${bookableRoom.get(0).type}</option>
										<c:forEach items="${bookableRoom }" var="room">
											<option value="${room.id }">${room.no }호</option>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<option value=""selected disabled hidden>예약방 선택</option>
										<c:forEach items="${bookableRoom }" var="room">
											<option value="${room.id }">${room.no }호 (${room.type })</option>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</select>
						</td>
					</tr>
					<tr>
						<td align="center">주소</td>
						<td><input type="text" name="addr" size="50"></td>
					</tr>
					<tr>
						<td align="center">전화번호</td>
						<td><input type="text" name="telnum"></td>
					</tr>
<!-- 					<tr>
						<td align="center">입금자명</td>
						<td><input type="text"></td>
					</tr> -->
					<tr>
						<td align="center">남기실말</td>
						<td><input type="text" name="comment" size="60"></td>
					</tr>
				</table>
				<input type="hidden" name="auth" value="user">
				
				<input type="button" value="전송" onClick="checkEvent('전송')" style="margin-left:600px;" />
				<input type="button" value="취소" onClick="checkEvent('취소')" />
			</form>
		</div>
		
		<script>
            function checkEvent(value) {
                if (value == '전송') {
                   	document.movement.action = "insert?roomId=" + document.movement.roomId.value;
                   	document.movement.submit();
                } else {
                	window.location = "list";
                }
            }
        </script>
	</body>
</html>