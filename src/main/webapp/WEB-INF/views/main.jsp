<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>그루 리조트에 놀러오신 것을 환영합니다.</title>
		<link rel="stylesheet" href="./css/main.css" type="text/css">
		<style type="text/css">
			div {
				text-align: center;
			}
		</style>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			function requestJson() {
				$.ajax({	//jquery
						type : "GET",
						url : "https://openapi.gg.go.kr/Sidoatmospolutnmesure",
						async : false,
						contentType : "application/json; charset=utf-8",
						dataType: 'text',
						data: {
							"KEY": "6b7935606dc744218fb3ba5e710ca389",
						    "Type": "json",
						    "pIndex": "1",
						    "pSize": "100",
						    "SIGUN_CD": "41130"
						},
						success : function(json) {
							var obj = JSON.parse(json);   //string이 object로 바뀜
							var location = obj['Sidoatmospolutnmesure'][1]['row'][10]['SIGUN_NM'];
							var detailLocation = obj['Sidoatmospolutnmesure'][1]['row'][10]['MESURSTN_NM'];
							//console.log(detailLocation);
							var value = obj['Sidoatmospolutnmesure'][1]['row'][10]['FINEDUST_PM10_DNST_VL'];
							var state = "";
							if (value < 30) {
								state = "좋음";
							} else if (value < 80) {
								state = "보통";
							} else if (value < 150) {
								state = "나쁨";
							} else {
								state = "매우나쁨";
							}
							$('.location').text(location +  " " + detailLocation + " 관측소");
							$('.target').text(value + "㎍/㎥ (" + state + ")");
						}
				});
			}
		</script>
	</head>
	<body>
		<div><%@include file="top.jsp" %></div>
		<div class="main">
			<div class="introduce">
				<img src="resources/main.jpg" width=750 height=500>
				<br>
				<h2>그루 리조트로 놀러오세요</h2>
			</div>
			<div style="margin-bottom:5px"><b>우리 지역의 미세먼지 농도</b></div>
			<div class="location"></div>
			<div class="target"><button onclick="requestJson()">확인하기</button></div>
			<div></div>
			
		</div>
    </body>
</html>