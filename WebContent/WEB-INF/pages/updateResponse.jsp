<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Your updates have been made</h2>
<div class="table-responsive">
<table class="table-hover">
	<tr>
		<th><label>Deck Title</label></th>
		<th><label>Deck Description</label></th>
	</tr>
	<tr>
		<td><label>${deck.title}</label></td>
		<td><label>${deck.description}</label></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="/home">Home</a>
		</td>
	</tr>
	</table>
</div>
</body>
</html>