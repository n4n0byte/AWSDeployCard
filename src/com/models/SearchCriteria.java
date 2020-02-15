package com.models;

import javax.validation.constraints.Size;

public class SearchCriteria {
	
	private Integer id;
	
	@Size(min=1,max=100)
	private String row;
	
	@Size(min=1,max=100)
	private String data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
