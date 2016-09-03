<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMP9321 Assignment 1 DBLP</title>
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
	<h3>Search for Books, Articles, Publications, anything!</h3>
	<form name="searchForms" action="./results" method="GET">
		<div class="form-group">
			<input type="text" name="searchQuery" class="form-control"
				placeholder=" Author, Title, or Type" /> 
			<input type="hidden" name="page" value="1" />
		</div>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
	<hr>
	<h2>Here are 10 Random Entries to showcase our wide variety of
		database!</h2>
	<br>
	<table class="table">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Year</th>
			<th>Type</th>
		</tr>
		<c:forEach var="random" items="${randomtens}">
			<tr>
				<td><a href="./details?id=${random.id}">${random.title}</a></td>
				<td>${random.author}</td>
				<td>${random.publisher}</td>
				<td>${random.year}</td>
				<td>${random.type}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

</body>
</html>