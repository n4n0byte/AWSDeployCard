package com.services.interfaces;

import java.util.List;

import com.models.Card;
/**
 * 
 * @author Anthony Natividad
 * Generic interface for all DAO objects
 * @param <Model>
 */
public interface GenericDAOInterface<Model> {
	
	
	/**
	 * returns all models of the generic type
	 * @return
	 */
	List<Model> findAll();
	
	/**
	 * finds a model by id
	 * @param id
	 * @return List<Model>
	 */
	Model getById(int id);
	
	/**
	 * finds all items by id
	 * @param id
	 * @return List<Model>
	 */
	List<Model> findAllById(int id);
	
	/**
	 * finds an item by name
	 * @param name String
	 * @return Model
	 */
	Model findByName(String name);
	
	/**
	 * Adds an item
	 * @param model Model
	 */
	void add(Model model);
	
	/**
	 * updates an item by id
	 * @param input Model
	 * @param id int
	 * @return boolean
	 */
	boolean updateById(Model input, int id);
	
	/**
	 * updates a model using its name
	 * @param input Model
	 * @param name String
	 * @return
	 */
	boolean updateByName(Model input, String name);
	
	/**
	 * deletes a model using its id
	 * @param id int
	 * @return
	 */
	boolean deleteById(int id);
	
	/**
	 * deletes a model using its name
	 * @param name String
	 * @return boolean
	 */
	boolean deleteByName(String name);
	
	/**
	 * adds a card, includes name
	 * @param input Card
	 * @param name String
	 */
	void addCardWithName(Card input, String name);
}
