<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<script type="text/javascript">
	// wait until page is ready
	$(function() {
		
		// initialize hidden confirmation dialog
		$('#deleteConfirmation').dialog({
			modal : true,
			width : 300,
			height : 200,
			autoOpen : false
		})

		// assign click eventhandler in delete to confirmation dialog
		$('.delete').click(function(event) {

			// bind this to current item
			var currentItem = $(this)

			// add buttons to dialog 
			$('#deleteConfirmation').dialog('option', 'buttons', [ {
				text : "Ok",
				click : function() {
					// go to delete link with deck id
					var deckTitle = currentItem.find("input").attr("value");
					window.location.href = "/deleteDeck/" + deckTitle;
				},
			}, {
				text : "Cancel",
				click : function() {
					// close dialog
					$("#deleteConfirmation").dialog("close");
				},
			}

			])
			$("#deleteConfirmation").html("Are You Sure?").dialog();
			$("#deleteConfirmation").dialog("open");

		})

		
	})
</script>


<div class="container">

	<div id="deleteConfirmation"></div>
	<div class="panel panel-default">

		<h2>Welcome ${user.username}</h2>
		<h3>List of Decks</h3>


		<div class="panel panel-default">

			<div>

				<div class="table-responsive">
					<table class="table table-hover">

						<tr>
							<th><label>Title</label></th>
							<th><label>Description</label></th>
							<th><label>Add Card</label></th>
							<th><label>Delete Deck</label></th>
							<th><label>Update Deck</label></th>

						</tr>

						<c:forEach var="deck" items="${decks}">

							<tr>

								<td><label><a
										href="/displayDeck/${deck.deckId}">${deck.title}</a></label></td>
								<td><label>${deck.description}</label></td>
								<td><label><a href="/newCard/${deck.title}">Add</a></label>
								</td>
								<td><label class="delete"> <input type="hidden"
										class="name" name="x" value="${deck.title}"> <a
										href="#">Delete</a>
								</label></td>
								<td><label><a href="/updateDeck/${deck.title}">Update</a></label>
								</td>
							</tr>
						</c:forEach>
					</table>

				</div>
			</div>
			<a href="/newDeck"><button class="col-sm-12">Add a
					Deck</button></a>
		</div>
	</div>

</div>