<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환율을 araboza</title>
<script  src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div id="basicDiv">
		<table border="2">
			<thead>
				<colgroup>
					<col style="width:40%; "/>
					<col style="width:30%" />
					<col style="width:30%" />
				</colgroup>
			</thead>
				<tr style="background-color:blue;">
					<th>통화명</th>
					<th>받으실때</th>
					<th>보내실때</th>
				</tr>
		<tbody>
		<c:forEach items="${data }" var="item" varStatus="status">
			<tr>
				<td>${item.cur_nm }	</td>
				<td> ${item.ttb } ${item.cur_unit }</td> 
				<td>${item.tts } ${item.cur_unit }</td> 
			</tr>
		</c:forEach>
		</tbody>
		</table>
</div>
</body>
</html>