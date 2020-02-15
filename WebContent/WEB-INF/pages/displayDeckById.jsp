<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<ul>
		<li><a href="/Card/home">Home</a></li>		
	</ul> <br/>
<div align="center">
<h2>List of Decks</h2>
<div class="table-responsive">
	<table class="table-hover">
		<tr>
			<th><label>First Name</label></th>
			<th><label>Last Name</label></th>
		</tr>
		<c:forEach var="deck" items="${decks}">
			<tr>
				<td><label>${decks.title}</label></td>
				<td><label>${decks.description}</label></td>
				<c:forEach var="card" items="${decks}">
					<td><label>${decks.cards}</label><td>
				</c:forEach>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">
			<a href="add">Add a User</a>
			</td>
		</tr>
	</table>
</div>
</div>