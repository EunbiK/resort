<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>위치</title>
		<%@include file="top.jsp" %>
	</head>
	<body BACKGROUND="resources/background.jpg" style="background-size:cover; background-repeat:no-repeat;"></body>
        <center>
        <table width=500>
            <div class="map">
                <div class="daumMap">
                    <div id="map" style="width:70%;height:700px;"></div>
                    <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=0ed8c36320984a0265eb6ca0430b838b"></script>
                    <script>
                        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                            mapOption = { 
                                center: new daum.maps.LatLng(37.385863, 127.121275), // 지도의 중심좌표
                                level: 3 // 지도의 확대 레벨
                            };
                        
                        var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
                        
                        // 마커가 표시될 위치입니다 
                        var markerPosition  = new daum.maps.LatLng(37.385863, 127.121275); 
                        
                        // 마커를 생성합니다
                        var marker = new daum.maps.Marker({
                            position: markerPosition
                        });
                        
                        // 마커가 지도 위에 표시되도록 설정합니다
                        marker.setMap(map);
                        
                        // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
                        // marker.setMap(null);    
                    </script>
                </div>
            </div>
        </table>
        <br> <h2>그루리조트의 위치</h2>
        </center>
    </body>
</html>