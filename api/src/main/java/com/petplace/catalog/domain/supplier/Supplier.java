package com.petplace.catalog.domain.supplier;

import java.util.ArrayList;
import java.util.List;

import com.petplace.catalog.domain.product.Product;
import com.petplace.catalog.domain.user.ContactDetails;
import com.petplace.catalog.domain.user.Password;
import com.petplace.catalog.domain.user.User;
import com.petplace.catalog.domain.user.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("SUPPLIER")

public class Supplier extends User {
    @Embedded
    private Cnpj cnpj;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();
    
    public Supplier(Password password, ContactDetails contactDetails, UserRole role) {
        super(password, contactDetails, UserRole.SUPPLIER);
    }
    
    public Cnpj getCnpj() {
        return cnpj;
    }
}
