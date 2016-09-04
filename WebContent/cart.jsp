<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="header.html"%>
	<h3>Inside the Cart:</h3>
	<c:choose>
		<c:when test="${empty cart}">
			Shopping Cart is Empty!
		</c:when>
		<c:otherwise>
			<form name="cartForms" action="./delete-cart" method="POST">
				<table class="table">
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Year</th>
						<th>Type</th>
						<th>Remove</th>
					</tr>
					<c:forEach var="entry" items="${cart}">
						<tr>
							<td><a href="./details?id=${entry.id}">${entry.title}</a></td>
							<td>${entry.author}</td>
							<td>${entry.publisher}</td>
							<td>${entry.year}</td>
							<td>${entry.type}</td>
							<td><input type="checkbox" value="${entry.id }" name="delete-cart" /></td>
						</tr>
					</c:forEach>
				</table>
				<button type="submit" class="btn btn-default">Remove from Cart</button>
			</form>
		</c:otherwise>
	</c:choose>
	<%@ include file="footer.html"%>

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>