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
	 * 
	 * @param id
	 * @return
	 */
	Model getById(int id);
	List<Model> findAllById(int id);
	Model findByName(String name);
	void add(Model model);
	boolean updateById(Model input, int id);
	boolean updateByName(Model input, String name);
	boolean deleteById(int id);
	boolean deleteByName(String name);
	void addCardWithName(Card input, String name);
}
