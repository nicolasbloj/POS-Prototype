package com.nab.posprototype.component.service;

import com.nab.posprototype.component.service.operation.PersistenceService;
import com.nab.posprototype.component.service.operation.SearchService;
import com.nab.posprototype.dto.ProductDTO;
import com.nab.posprototype.model.Product;

public interface ProductService extends SearchService<Integer, Product, ProductDTO>,
    PersistenceService<Integer, Product, ProductDTO> {

}
