package com.petplace.catalog.domain.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, ProductID> {
    
}
