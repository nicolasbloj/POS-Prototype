package com.nab.posprototype.component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nab.posprototype.component.service.ProductService;
import com.nab.posprototype.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/get.do")
	public Product getAproduct() {
		return productService.getAproduct();
	}
}
