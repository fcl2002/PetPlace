package com.petplace.catalog.domain.product;

import org.springframework.util.Assert;

public record Price(Double price) {
    
    public Price {
        Assert.notNull(price, "Invalid price: " + price + " must not be null.");
        Assert.isTrue(price > 0, "Invalid price: " + price + " must be greater than zero.");
    }
}