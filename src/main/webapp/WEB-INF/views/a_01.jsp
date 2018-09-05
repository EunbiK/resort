<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@include file="top.jsp" %> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>vip룸</title>
		<!-- <style type="text/css">
		    @import url("main.css");
		</style> -->
		<!-- <link rel="stylesheet" href="main.css" type="text/css"> -->
		
		<style type="text/css">
			body {
				margin: 0;
			}
		    .main { 
		    	background-image: url("resources/background.jpg");
		    	background-size:cover;
		    	background-repeat:no-repeat;
		    	height: calc(100vh - 80px);
		    }
		    .introduce {
				width: 750px;
				margin: 0 auto;

		    }
		</style>
	</head>
    
    <body>
    	<div><%@include file="top.jsp" %></div>
		<div class="main">
			<div class="introduce">
				<img src="resources/a_01.jpg" width=750 height=500 style="margin-top:50px;">
				<br>
				<h2> VIP룸은 럭셔리 휴식공간입니다. </h2>
			</div>
		</div>
	</body>
</html>

