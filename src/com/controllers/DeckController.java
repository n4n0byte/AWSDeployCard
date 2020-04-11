package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
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
import com.services.interfaces.DeckBusinessServiceInterface;

/**
 * 
 * @author Ali Cooper & Anthony Natividad
 * Handles all get and post mapping methods for deck modules in view pages
 * Implements DeckBusinessService
 */
@Controller
public class DeckController {

	DeckBusinessServiceInterface deckSvc;
	
	private XLogger logger = XLoggerFactory.getXLogger(DeckController.class);
	
	/**
	 * inject deck business service
	 * @param iDeckBusinessService
	 */
	@Autowired
	public void setIDeckBusinessService(DeckBusinessServiceInterface iDeckBusinessService) {
		logger.entry();
		deckSvc = iDeckBusinessService;
		logger.exit();
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
		logger.entry();

		// validation 
		if (result.hasErrors()) {
			logger.warn("validation errors: "+result.getErrorCount());
			modelMap.put("message", "Validation Error");
			return "newDeck";
		}
		
		// get user from session and assign the given userId to
		// the deck
		User user = (User) sess.getSession().getAttribute("user");
		deck.setUserId(user.getId());
		deckSvc.addDeck(deck);
		logger.exit();
		return "redirect:/home";
	}
	
	/**
	 * Displays the deck view
	 * @param deckId
	 * @param modelMap
	 * @param attrs
	 * @param sess
	 * @return Display deck View
	 */
	@GetMapping("displayDeck/{deckId}")
	public String displayDeck(@PathVariable("deckId") int deckId,ModelMap modelMap, RedirectAttributes attrs, HttpServletRequest sess) {
		logger.entry();
		logger.info("entering DeckController.displayDeck" + "|deckId: " + deckId);

		Deck deck = deckSvc.findDeckByDeckId(deckId);
		System.out.println(deck);
		
		// return home with deck not found
		if (deck == null) {
			modelMap.put("message", "error");
			return "redirect:home";
		}
		
	
		modelMap.put("deck", deck);
		logger.exit();
		return "displayDeck";
	}	
	
	/**
	 * adds a card
	 * @param cardWithDeckTitle
	 * @param modelMap
	 * @param result
	 * @return Deck View
	 */
	@PostMapping("addCard")
	public String addCard(@ModelAttribute("cardWithDeckTitle")CardWithDeckTitle cardWithDeckTitle, ModelMap modelMap, BindingResult result) {
		logger.entry();
		logger.info("entering DeckController.addCard" + "|cardWithDeckTitle: " + cardWithDeckTitle);
		
		//validate only title and description
		if (result.hasErrors()) {
			logger.warn("validation errors: "+result.getErrorCount());
			modelMap.put("message", "Validation Error");
			return "newCard";
		}
		
		modelMap.put("message", "Successfully Added Card");
		deckSvc.addCardToDeckWithDeckTitle(cardWithDeckTitle.getCard(), cardWithDeckTitle.getDeckTitle());
		logger.exit();
		return "redirect:/home";
		
	}	
	
	/**
	 * show update view
	 * @param deck
	 * @param modelMap
	 * @param result
	 * @param attrs
	 * @return Updates deck
	 */
	@GetMapping("updateDeck/{deckTitle}")
	public ModelAndView updateDeck(@ModelAttribute("Deck")Deck deck, ModelMap modelMap, BindingResult result, RedirectAttributes attrs) {
		logger.entry();
		logger.info(deck.toString());
		logger.exit();
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
		System.out.println("hi");
		logger.entry();
		//validate only title and description
		if (result.hasErrors()) {
			logger.warn("validation errors: "+result.getErrorCount());
			logger.warn("error deck: " + deck);
			modelMap.put("message", "Validation Error");
			return "updateResponse.jsp";
		}
		
		modelMap.put("message", "Successfully updated Deck");
		System.out.println("DECKDECKDECK " + deck);
		User usr = (User) req.getSession().getAttribute("user");
		logger.info(usr.toString());
		deck.setUserId(usr.getId());
		deckSvc.updateDeck(deck);
		logger.exit();
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
		logger.entry();
		deckSvc.deleteDeckByTitle(title);
		logger.exit();
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
		logger.entry();
		//validate only title and description
		if (result.hasErrors()) {
			logger.info("Validation errors " + result.getErrorCount());
			modelMap.put("message", "Validation Error");
			return "displayFindByid.jsp";
		}
		
		modelMap.put("message", "Successfully updated Deck");
		deckSvc.updateDeck(deck);
		logger.exit();
		return "redirect:/home";
		
	}	
}
