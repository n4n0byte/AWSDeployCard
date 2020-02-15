<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div align="center">	
	<form:form method="POST" class="panel panel-default margin col-sm-offset-4 col-sm-4 form-horizontal"  modelAttribute="cardWithDeckTitle" action="/addCard">	
	
		
		<h2>Add Card To Deck</h2>
				
		<h2>
			${message}
		</h2>	
		
		<div id="cardForm" class="form-group">
			
			<div class="col-sm-12">
				<form:input  path="card.title" placeholder="Title" class="form-control" minlength="3" maxlength="10" required="required"/>						
			</div>
			
			<div class="col-sm-12">
				<form:errors class="control-label" path="card.title"/>
			</div>
			
		</div>		
		
		<div class="form-group">
			<div class="col-sm-12">
				<form:input path="card.description" placeholder="Description" class="form-control"  minlength="3" maxlength="10" required="required" />
			</div>
			<div class="col-sm-12">
				<form:errors class="form-label" path="card.description"/>		
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-12">
				<form:input path="card.health" placeholder="Health" class="form-control"   maxlength="10" required="required" />
			</div>
			<div class="col-sm-12">
				<form:errors class="form-label" path="card.health"/>		
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-12">
				<form:input path="card.damage" placeholder="Damage" class="form-control"  maxlength="10" required="required" />
			</div>
			<div class="col-sm-12">
				<form:errors class="form-label" path="card.damage"/>		
			</div>
		</div>
		<form:hidden path="deckTitle"/>
		
		
		<div class="form-group">
			<div class="col-sm-12">
				<input type="submit" class="col-sm-offset-3 col-sm-6 btn btn-primary" value="Submit"/>			
			</div>
		</div>
		
		
	</form:form>	
</div>