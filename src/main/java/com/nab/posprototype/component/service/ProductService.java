package com.nab.posprototype.component.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nab.posprototype.component.repository.ProductRepository;
import com.nab.posprototype.dto.ProductDTO;
import com.nab.posprototype.model.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	@Qualifier("productRepositoryHbn")
	ProductRepository repository;

	public Integer add(ProductDTO productDTO) {
		try {
			Product productIn = repository.persist(new Product(productDTO.getCode(), productDTO.getDescription()));
			return productIn.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<Product> list() {
		return repository.list();
	}

	public Product getByKey(Integer id) {
		return repository.getByKey(id);
	}

}
