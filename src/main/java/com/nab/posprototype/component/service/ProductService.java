package com.nab.posprototype.component.service;

import org.springframework.stereotype.Service;

import com.nab.posprototype.model.Product;

@Service
public class ProductService {

	public Product getAproduct() {
		return new Product("AA1", "Aire acondicionado");
	}

}
