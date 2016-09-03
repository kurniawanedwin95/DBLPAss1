<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Search Results</title>
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
	<h2>Your searched for: ${searchQuery}</h2>
	<c:choose>
		<c:when test="${empty results}">
			Sorry, no matching datasets found!
		</c:when>
		<c:otherwise>
			<table class="table">
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Year</th>
					<th>Type</th>
				</tr>
				<c:forEach var="result" items="${results}">
					<tr>
						<td><a href="./details?id=${result.id}">${result.title}</a></td>
						<td>${result.author}</td>
						<td>${result.publisher}</td>
						<td>${result.year}</td>
						<td>${result.type}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page == 1 and lastPage eq true }">
		</c:when>
		<c:when test="${page == 1}">
			<a href="./results?searchQuery=${searchQuery}&page=${page+1}" class="btn btn-default">Next Page</a>
		</c:when>
		<c:when test="${lastPage eq true}">
			<a href="./results?searchQuery=${searchQuery}&page=${page-1}" class="btn btn-default">Previous Page</a>
		</c:when>
		<c:otherwise>
			<a href="./results?searchQuery=${searchQuery}&page=${page-1}" class="btn btn-default">Previous Page</a>
			<a href="./results?searchQuery=${searchQuery}&page=${page+1}" class="btn btn-default">Next Page</a>
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