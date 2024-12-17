package com.petplace.catalog.domain.user;

import java.util.regex.Pattern;

public record Password(String password) {
    private static final String PASSWORD_REGEX = 
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public Password {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException(
                "Invalid password: " + password + "\n" +
                "Must be at least 8 characters long with at least one uppercase letter, " + 
                "one lowercase letter, one number, and one special character (@$!%*?&).");
        }
    }
}
