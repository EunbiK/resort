<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예약화면</title>
	</head>
	<body>
		<div><%@include file="top.jsp" %></div>
		<div>
			<form action="/insert">
				<table border="1" width="700" cellspacing="0" cellpadding="3">
					<tr>
						<td width="100">성명</td>
						<td><input type="text"></td>
					</tr>
					<tr>
						<td>예약일자</td>
						<td><input type="text"></td>
					</tr>
					<tr>
						<td>예약방</td>
						<td><select>
								<optgroup label="${roomtype}">
									<option value="합리적인룸">합리적인룸</option>
									<option value="일반룸">일반룸</option>
									<option value="VIP룸">VIP룸</option>
								</optgroup>
							</select></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" size="50"></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text"></td>
					</tr>
					<tr>
						<td>입금자명</td>
						<td><input type="text"></td>
					</tr>
					<tr>
						<td>남기실말</td>
						<td><input type="text" size="60"></td>
					</tr>
				</table>
				<input type="button" value="전송" style="margin-left:600px;" />
				<input type="button" value="취소" />
			</form>
		</div>
	</body>
</html>