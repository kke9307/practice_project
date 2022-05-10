<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>map</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vtw8zgwrd6"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    
</head>
<body>
<input type="text" name="search" id="search">
<input type="button" id="searchBtn" value="검색">

<div id="map" style="width:100%;height:400px;"></div>


<script type="text/javascript">

$(document).ready(function() {
	$("#searchBtn").click(function(){
		var searchAddr = $("#search").val();
		if(searchAddr == ""){
			alert("주소를 입력하세요");
			return false;
		}else{
			searchLocation(searchAddr);
		}
	});
});
function searchLocation(searchAddr){
	$.ajax({
		url     : "/naver_location_proc.do",
		type    : "POST",
		data    : {
			searchAddr : searchAddr,
		},
		dataType: "json",
		error   : function(request, status, error) {
			alert("에러가 발생하였습니다.");
		},
		success:function(data) {
			alert("data= "+data[0]);
			initMap(data[0].y,data[0].x,data[0].roadAddress);
		} 
	}); 
}

function initMap(lat,lon,areaNm) { 
	alert(areaNm);
	$("#map").focus();
	var map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(lat, lon), //지도 시작 지점
        zoom: 15
    });
	var marker = new naver.maps.Marker({
        map: map,
        title: areaNm, // 이름 
        position: new naver.maps.LatLng(lat , lon) // 위도 경도 넣기 
    });
    
    /* 정보창 */
	 var infoWindow = new naver.maps.InfoWindow({
	     content: '<div style="width:200px;text-align:center;padding:10px;"><b>' + areaNm + '</b></div>'
	 }); // 
    infoWindow.open(map, marker); // 표출
}

</script>
</body>
</html>