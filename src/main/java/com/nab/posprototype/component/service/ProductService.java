package com.nab.posprototype.component.service;

import java.util.ArrayList;
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
      Product productIn =
          repository.persist(new Product(productDTO.getCode(), productDTO.getDescription()));
      return productIn.getId();
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  public List<ProductDTO> list() {
    List<Product> products = repository.list();
    List<ProductDTO> productsDTO = new ArrayList<>();

    products.forEach((final Product product) -> productsDTO
        .add(new ProductDTO(product.getCode(), product.getDescription())));

    return productsDTO;
  }

  public ProductDTO getByKey(Integer id) {
    Product product = repository.getByKey(id);
    try {
      return new ProductDTO(product.getCode(), product.getDescription());
      // Deberiamos tener nuestras propias clases que manejen las exceptions...
    } catch (NullPointerException e) {
      // logging...
      return null;
    }

  }

}
