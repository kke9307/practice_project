<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아파트 매매</title>
</head>
<link rel="stylesheet" type="text/css" href="../../css/style.css" /> 
<body>
<table class="type10">
	<thead>
	  <tr>
	    <th>코드</th>
	    <th>값</th>
	  </tr>
 	</thead>
	<c:forEach var="item" items="${trading }" varStatus="status">
		<c:forEach var="entry" items = "${item }" varStatus="entryStatus">
			<tr>
				<th scope="row">${entry.key }</th>
				<td>${entry.value }</td>
			</tr> 
		</c:forEach>
	 </c:forEach>
 </table>
</body>
</html>