package com.petplace.catalog.domain.category;

import java.util.UUID;

import org.springframework.util.Assert;

public record CategoryID(UUID id) {

    public CategoryID {
        Assert.notNull(id, "id must not be null");
    }

    public CategoryID() {
        this(UUID.randomUUID());
    }
    
}
