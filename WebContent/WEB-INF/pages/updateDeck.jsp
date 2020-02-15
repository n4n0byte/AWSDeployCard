<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div align="center">
	<div id="updateDeck">

		<div class="container">
		

			<form:form method="POST"
				class="panel panel-default margin col-sm-offset-4 col-sm-4 form-horizontal"
				modelAttribute="Deck" action="/updateResponse">


				<h2>Update Deck</h2>
	
				<div id="updateForm" class="form-group">

					<div class="col-sm-12">
						<form:input path="title" placeholder="Title" class="form-control"
							minlength="3" maxlength="10" required="required" />
					</div>

					<div class="col-sm-12">
						<form:errors class="control-label" path="title" />
					</div>

				</div>

				<div class="form-group">
					<div class="col-sm-12">
						<form:input path="description" placeholder="Description"
							class="form-control" minlength="3" maxlength="10"
							required="required" />
					</div>
					<div class="col-sm-12">
						<form:errors class="form-label" path="description" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-12">
						<input type="submit"
							class="col-sm-offset-3 col-sm-6 btn btn-default" value="Submit" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
