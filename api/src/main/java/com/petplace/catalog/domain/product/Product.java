package com.petplace.catalog.domain.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.util.Assert;

import com.petplace.catalog.application.ProductInformation;
import com.petplace.catalog.domain.category.Category;
import com.petplace.catalog.domain.supplier.Supplier;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")

public class Product {
    
    @EmbeddedId
    private ProductID id;

    private String name;

    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "unitPrice"))
    private Price unitPrice;
    
    private String description;
    private String imageUrl;
    
    @Embedded
    @AttributeOverride(name = "stock", column = @Column(name = "stock"))
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    Product() { }

    public Product(ProductInformation info) {

        Assert.notNull(info.name(), "Product name cannot be null");
        Assert.notNull(info.description(), "Product description cannot be null");
        
        this.id = new ProductID();
        this.name = info.name();
        this.unitPrice = info.unitPrice();
        this.description = info.description();
        this.imageUrl = info.imageUrl();
        this.stock = info.stock();
        this.supplier = info.supplier();
        this.categories = info.categories();    
    }

    public ProductID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Stock getStock() {
        return stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public List<Category> getCategories() {
        return categories;
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
