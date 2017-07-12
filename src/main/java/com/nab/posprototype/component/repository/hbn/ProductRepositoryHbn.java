package com.nab.posprototype.component.repository.hbn;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nab.posprototype.component.repository.ProductRepository;
import com.nab.posprototype.model.Product;

/**
 *
 * @author root
 */
@Repository("productRepositoryHbn")
@Transactional
public class ProductRepositoryHbn extends RepositoryHbn<Integer, Product>
    implements ProductRepository {



}
