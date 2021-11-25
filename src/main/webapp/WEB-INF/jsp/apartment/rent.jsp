<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>아파트 전월세</title>
</head>
<body>
<div id="header"></div>
<div>
<table class="type10" style="border: 1px">
	<thead>
	  <tr>
	    <th>코드</th>
	    <th>값</th>
	  </tr>
 	</thead>
	<c:forEach var="item" items="${rent }" varStatus="status">
		<c:forEach var="entry" items = "${item }" varStatus="entryStatus">
			<tr>
				<th scope="row">${entry.key }</th>
				<td>${entry.value }</td>
			</tr> 
		</c:forEach>
	 </c:forEach>
 </table>
 </div>
 <body>
<div id="footer"></div>
</body>
</html>