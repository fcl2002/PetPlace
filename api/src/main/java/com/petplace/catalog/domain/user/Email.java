package com.petplace.catalog.domain.user;

import org.apache.commons.validator.routines.EmailValidator;

public record Email(String email) {
    private static final EmailValidator VALIDATOR = EmailValidator.getInstance();

    public Email {
        if(!VALIDATOR.isValid(email)) {
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
    }
}
