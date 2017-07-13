package com.nab.posprototype.component.repository;

import com.nab.posprototype.component.repository.operation.PersistenceRepository;
import com.nab.posprototype.component.repository.operation.SearchRepository;
import com.nab.posprototype.model.Product;

/**
 *
 * @author root
 */
public interface ProductRepository
    extends SearchRepository<Integer, Product>, PersistenceRepository<Integer, Product> {


}
