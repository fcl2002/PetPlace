package com.petplace.catalog.application;

import java.util.List;

import com.petplace.catalog.domain.category.Category;
import com.petplace.catalog.domain.product.Price;
import com.petplace.catalog.domain.product.Stock;
import com.petplace.catalog.domain.supplier.Supplier;

public record ProductInformation(String name, Price unitPrice, String description, String imageUrl, Stock stock, Supplier supplier, List<Category> categories) {

}
