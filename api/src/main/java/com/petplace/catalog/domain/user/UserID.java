package com.petplace.catalog.domain.user;

import java.util.UUID;

import org.springframework.util.Assert;

public record UserID(UUID id) {

    public UserID {
        Assert.notNull(id, "id must no be null");
    }

    public UserID() {
        this(UUID.randomUUID());
    }
}
