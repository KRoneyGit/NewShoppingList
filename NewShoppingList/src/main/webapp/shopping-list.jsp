<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View all items</title>
</head>
<body>
	<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
			<tr>
				<td><input type="radio" name="id" value="${currentitem.id}"></td>
				<td>${currentitem.store}</td>
				<td>${currentitem.item}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>