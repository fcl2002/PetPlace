package com.petplace.catalog.application;

import com.petplace.UseCase;
import com.petplace.catalog.domain.product.Product;
import com.petplace.catalog.domain.product.ProductRepository;

@UseCase
public class RegisterProductUseCase {
    private final ProductRepository productRepository;

    public RegisterProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void register(ProductInformation info) {
        Product product = new Product(info);
        productRepository.save(product);
    }
}
