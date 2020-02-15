package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.CardWithDeckTitle;
import com.models.Deck;
import com.models.User;
import com.services.implementations.DeckBusinessService;
import com.services.interfaces.DeckBusinessServiceInterface;
import com.services.interfaces.GenericDAOInterface;

/**
 * 
 * @author Ali Cooper & Anthony Natividad
 * Handles all get and post mapping methods for deck modules in view pages
 * Implements DeckBusinessService
 */
@Controller
public class DeckController {

	DeckBusinessServiceInterface deckSvc;
	
	/**
	 * inject deck business service
	 * @param iDeckBusinessService
	 */
	@Autowired
	public void setIDeckBusinessService(DeckBusinessServiceInterface iDeckBusinessService) {
		deckSvc = iDeckBusinessService;
	}
	
	/**
	 * Creates a new deck with 
	 * submitted deck model
	 * @param deck
	 * @param modelMap
	 * @param result
	 * @param sess
	 * @return new Deck View 
	 */
	@PostMapping("newDeck")
	public String newDeck(@Valid @ModelAttribute("deck")Deck deck,ModelMap modelMap, BindingResult result, HttpServletRequest sess) {
		
		// validation 
		if (result.hasErrors()) {
			modelMap.put("message", "Validation Error");
			return "newDeck";
		}
		
		// get user from session and assign the given userId to
		// the deck
		User user = (User) sess.getSession().getAttribute("user");
		deck.setUserId(user.getId());
		deckSvc.addDeck(deck);
		return "redirect:/home";
	}
	
	/**
	 * 
	 * @param deckId
	 * @param modelMap
	 * @param attrs
	 * @param sess
	 * @return Display deck View
	 */
	@GetMapping("displayDeck/{deckId}")
	public String displayDeck(@PathVariable("deckId") int deckId,ModelMap modelMap, RedirectAttributes attrs, HttpServletRequest sess) {
				
		Deck deck = deckSvc.findDeckByDeckId(deckId);
		System.out.println(deck);
		
		// return home with deck not found
		if (deck == null) {
			modelMap.put("message", "error");
			return "redirect:home";
		}
		
	
		modelMap.put("deck", deck);
		
		return "displayDeck";
	}	
	
	/**
	 * 
	 * @param cardWithDeckTitle
	 * @param modelMap
	 * @param result
	 * @return Deck View
	 */
	@PostMapping("addCard")
	public String addCard(@ModelAttribute("cardWithDeckTitle")CardWithDeckTitle cardWithDeckTitle, ModelMap modelMap, BindingResult result) {
		
		System.out.println("IN ADD CARD POST: " + cardWithDeckTitle);
		
		//validate only title and description
		if (result.hasErrors()) {
			modelMap.put("message", "Validation Error");
			return "newCard";
		}
		
		modelMap.put("message", "Successfully Added Card");
		deckSvc.addCardToDeckWithDeckTitle(cardWithDeckTitle.getCard(), cardWithDeckTitle.getDeckTitle());
		
		return "redirect:/home";
		
	}	
	
	/**
	 * 
	 * @param deck
	 * @param modelMap
	 * @param result
	 * @param attrs
	 * @return Updates deck
	 */
	@GetMapping("updateDeck/{deckTitle}")
	public ModelAndView updateDeck(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result, RedirectAttributes attrs) {
		
		
		return new ModelAndView("updateDeck","Deck",new Deck());
		
	}
	
	/**
	 * Updates a deck
	 * @param deck
	 * @param modelMap
	 * @param result
	 * @param req
	 * @return Home View
	 */
	@PostMapping("updateResponse")
	public String updateResponse(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result, HttpServletRequest req) {
		
		//validate only title and description
		if (result.hasErrors()) {
			modelMap.put("message", "Validation Error");
			return "updateResponse.jsp";
		}
		
		modelMap.put("message", "Successfully updated Deck");
		System.out.println("DECKDECKDECK " + deck);
			User usr = (User) req.getSession().getAttribute("user");
		deck.setUserId(usr.getId());
		deckSvc.updateDeck(deck);
		return "redirect:/home";
		
	}	
	
	/**
	 * Deletes a deck
	 * @param title
	 * @param modelMap
	 * @return Home View
	 */
	@GetMapping("deleteDeck/{deckTitle}")
	public String deleteDeck(@PathVariable("deckTitle") String title, ModelMap modelMap) {
		deckSvc.deleteDeckByTitle(title);
		return "redirect:/home";
		
	}
	
	/**
	 * displays deck by id
	 * @param deck
	 * @param modelMap
	 * @param result
	 * @return Display Deck View
	 */
	@PostMapping("displayfindById")
	public String displayfindById(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result) {
		
		//validate only title and description
		if (result.hasErrors()) {
			modelMap.put("message", "Validation Error");
			return "displayFindByid.jsp";
		}
		
		modelMap.put("message", "Successfully updated Deck");
		deckSvc.updateDeck(deck);
		return "redirect:/home";
		
	}	
}
