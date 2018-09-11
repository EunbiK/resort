<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
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
						//console.log(json)
						var obj = JSON.parse(json);   //string이 object로 바뀜
						//console.log(obj);
						var value = obj['Sidoatmospolutnmesure'][1]['row'][0]['FINEDUST_PM2_5_DNST_VL'];
						//console.log(value);
						$('#target').text(value);
					}
			});
		}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>

<div id="target">target</div>
<div><a href="main">main</a></div>
<div><a href="login">login</a></div>
<div><button onclick="requestJson()">requestJson</button></div>
</body>
</html>
