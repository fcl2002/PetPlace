package com.petplace.catalog.domain.product;

import org.springframework.util.Assert;

public record Stock(Integer stock) {
    public Stock {
        Assert.notNull(stock, "Product stock: " + stock + " cannot be null.");
        Assert.isTrue(stock >= 0, "Product stock: " + stock + " cannot be negative.");
    }
}
