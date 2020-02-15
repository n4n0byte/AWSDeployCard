<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div align="center"></div>
<h2>List of Cards</h2>
<div class="table-responsive">
	<table class="table-hover">
		<tr>
			<th><label>Card Title</label></th>
			<th><label>Description</label></th>
			<th><label>Health</label></th>
			<th><label>Damage</label></th>
		</tr>
		<c:forEach var="card" items="${cards}">
			<tr>
				<td><label>${cards.title}</label></td>
				<td><label>${cards.description}</label></td>
				<td><label>${cards.health}</label></td>
				<td><label>${cards.damage}</label></td>
			</tr>
		</c:forEach>		
	</table>
</div>