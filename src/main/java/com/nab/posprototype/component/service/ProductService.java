package com.nab.posprototype.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nab.posprototype.component.repository.ProductRepository;
import com.nab.posprototype.model.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	@Qualifier("productRepositoryHbn")
	ProductRepository repository;

	// esta bien enviar los parametros de esta forma,desde controller a service ?
	// o recibir un objeto product en service ?
	// !
	public Integer persist(String code, String desc) {
		try {
			Product productIn = repository.persist(new Product(code, desc));
			return productIn.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

}
