package com.nab.posprototype.dto.converter;

import com.nab.posprototype.dto.ProductDTO;
import com.nab.posprototype.model.Product;

public class ProductConverter {

  public static ProductDTO convertToDTO(Product product) {
    return new ProductDTO(product.getCode(), product.getDescription());
  }

  public static Product convertDTO(ProductDTO productDTO) {
    return new Product(productDTO.getCode(), productDTO.getDescription());
  }

}
