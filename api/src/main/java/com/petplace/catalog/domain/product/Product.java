package com.petplace.catalog.domain.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.Assert;

import com.petplace.catalog.domain.category.Category;
import com.petplace.catalog.domain.user.Supplier;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")

public class Product {
    
    @EmbeddedId
    private ProductID id;

    private String name;
    private Double price;
    private String description;
    private int stock;

    private Supplier supplier;

    private List<Category> categories = new ArrayList<>();

    Product() { }

    public Product(String name, Double price, String description, int stock,
                    Supplier supplier, List<Category> categories) {

        Assert.notNull(name, "name must not be null");
        Assert.notNull(price, "price must not be null");
        Assert.isTrue(price >= 0, "price must be positive");
        Assert.notNull(description, "description must not be null");
        Assert.isTrue(stock >= 0, "stock must be positive");
        Assert.notNull(stock, "stock must not be null");
        
        this.id = new ProductID();
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.supplier = supplier;
        this.categories = categories;
    }

    public ProductID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
