package com.petplace.catalog.domain.product;

import java.util.UUID;

import org.springframework.util.Assert;

public record ProductID(UUID id) {

    public ProductID {
        Assert.notNull(id, "id must not be null");
    }

    public ProductID() {
        this(UUID.randomUUID());
    }
}
