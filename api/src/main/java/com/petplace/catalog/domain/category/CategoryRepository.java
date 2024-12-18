package com.petplace.catalog.domain.category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, CategoryID> {
    
}
