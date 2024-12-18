package com.petplace.catalog.domain.supplier;

import org.springframework.data.repository.CrudRepository;

import com.petplace.catalog.domain.user.UserID;

public interface SupplierRepository extends CrudRepository<Supplier, UserID> {
}
