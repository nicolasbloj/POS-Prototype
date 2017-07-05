package com.nab.posprototype.component.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nab.posprototype.component.service.ProductService;
import com.nab.posprototype.dto.ProductDTO;
import com.nab.posprototype.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST, 
			consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> add(@RequestBody(required = true) ProductDTO productDTO) {
		ResponseEntity<String> response;
		try {
			Integer id = service.add(productDTO);
			if (id == -1)
				response = new ResponseEntity<String>(
						"No se pudo insertar el producto " + productDTO.getCode(),
						HttpStatus.INTERNAL_SERVER_ERROR
						);

			response = new ResponseEntity<String>(
					new StringBuilder().append("El producto ")
					.append(id)
					.append(" fue correctamente insertado")
					.toString(),
					HttpStatus.OK
					);

			
		} catch (Exception e) {
			response = new ResponseEntity<String>(
					"An error happens while trying to add the product " + productDTO.getCode(),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}

		return response;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Product> list() {
		return service.list();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public Product getByKey(@PathVariable Integer id) {
		return service.getByKey(id);
	}
}
