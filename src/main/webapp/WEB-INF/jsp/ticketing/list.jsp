<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }

</style>
<body>
<h2>${searchDate }</h2>
<c:forEach items="${movieList}" var="item" varStatus="status">
<table>
	<thead>
<!-- 		<tr>
          <th>ㅇㅇ</th><th>ㅇㅇㅇ</th><th>ㅇㅇㅇㅇ</th>
        </tr> -->
    </thead>
    <c:forEach items="${item }" var="movie" varStatus="status_1">
	<tbody>
		<tr>
			<td>${movie }</td>
		</tr>
	</tbody>
	</c:forEach>
</table>
</c:forEach>
</body>
</html>