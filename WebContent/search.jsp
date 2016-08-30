<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMP9321 Assignment 1 DBLP</title>
</head>
<body>
	<%@ include file="header.html" %>
	<h2>This page is currently under construction, so please bear with
		it for the time being.</h2>
	<h3>Search for Books, Articles, Publications, anything!</h3>
	<form name="searchForms" action="result.jsp" method="GET">
		<ul>
			<li>Type of Entry: <input type="text" name="searchEntryType" /></li>
			<li>Author: <input type="text" name="searchAuthor" /></li>
			<li>Title: <input type="text" name="searchTitle" /></li>
			<li>Publisher: <input type="text" name="searchPublisher" /></li>
			<li>Year: <input type="text" name="searchYear" /></li>
			<li>Pages: <input type="text" name="searchPages" /></li>
			<li>ISBN: <input type="text" name="searchISBN" /></li>
			<li>EE: <input type="text" name="searchEE" /></li>
		</ul>
		<input type="submit" value="Search!" name="submitSearchParams" />
	</form>
	<hr>
	<h2>Here are 10 Random Entries to showcase our wide variety of database!</h2>
</body>
</html>