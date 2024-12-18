package com.petplace.catalog.domain.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.Assert;

import com.petplace.catalog.domain.product.ProductID;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")

public class Category {
    @EmbeddedId
    private CategoryID id;

    private String name;

    @ManyToMany
    private List<ProductID> products = new ArrayList<>();

    Category() { }

    public Category(String name, List<ProductID> products) {

        Assert.notNull(name, "Category name must not be null");

        this.id = new CategoryID();
        this.name = name;
        this.products = products;
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProductID> getProductsIds() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
