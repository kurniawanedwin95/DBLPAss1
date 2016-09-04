<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Publication Details</title>
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
	<h3>More Details</h3>
	<form name="detailForms" action="./add-cart" method="POST">
		<ul>
			<li>Type of Entry: ${details.type }</li>
			<li>Author(s): <strong>${details.author }</strong></li>
			<li>Title: <strong>${details.title }</strong></li>
			<li>Publisher: ${details.publisher }</li>
			<li>Editor: ${details.editor }</li>
			<li>Address: ${details.address }</li>
			<li>Year: ${details.year }</li>
			<li>Number: ${details.number }</li>
			<li>Series: ${details.series }</li>
			<li>ISBN: <i>${details.isbn }</i></li>
			<li>URL: <i>${details.url }</i></li>
		</ul>
		<button type="submit" class="btn btn-primary">Add to Cart</button>
		<input type="hidden" value="${details.id }" name="id"/>
	</form>
	<%@ include file="footer.html" %>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>