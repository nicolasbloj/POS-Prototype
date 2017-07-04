package com.nab.posprototype.model;

public class Product {

	private long id;
	private String code;
	private String description;
	
	public Product() {
		super();
	}

	public Product(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	
	
	
	
}
