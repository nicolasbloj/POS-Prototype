package com.nab.posprototype.component.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nab.posprototype.component.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	// GET or POST ? -ResponseEntity
	@RequestMapping(method = RequestMethod.GET, value = "/persist.do/{code}/{desc}")
	public String persist(@PathVariable String code, @PathVariable String desc) {
		Integer id = service.persist(code, desc);
		if (id == -1)
			return "No se pudo insertar el producto";

		return new StringBuilder()
				.append("El producto ")
				.append(id)
				.append(" fue correctamente insertado")
				.toString();
	}

}
