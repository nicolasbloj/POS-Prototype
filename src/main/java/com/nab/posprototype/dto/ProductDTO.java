package com.nab.posprototype.dto;

public class ProductDTO {

	private String code;
	private String description;

	public ProductDTO() {
	}

	public ProductDTO(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
