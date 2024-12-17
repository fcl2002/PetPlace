package com.petplace.catalog.domain.user;

import java.util.regex.Pattern;

public record Phone(String phone) {
    private static final String PHONE_FORMATTED_REGEX = "\\(\\d{2}\\)\\d{5}-\\d{4}";
    private static final String PHONE_ONLY_NUMBERS_REGEX = "\\d{2}\\s?\\d{9}";

    private static final Pattern PHONE_FORMATTED_PATTERN = Pattern.compile(PHONE_FORMATTED_REGEX);
    private static final Pattern PHONE_ONLY_NUMBERS_PATTERN = Pattern.compile(PHONE_ONLY_NUMBERS_REGEX);

    public Phone(String phone) {
        String formattedPhone = formatPhone(phone);

        if(!PHONE_FORMATTED_PATTERN.matcher(phone).matches()) {
            throw new IllegalArgumentException("Invalid phone: " + phone);
        }

        this.phone = formattedPhone;
    }

    private static String formatPhone(String phone) {
        String digits = phone.replaceAll("\\D", "");

        if(!PHONE_ONLY_NUMBERS_PATTERN.matcher(digits).matches()) {
            throw new IllegalArgumentException("Invalid phone: " + phone);
        }

        return String.format("(%s)%s-%s",
                digits.substring(0, 2),
                digits.substring(2, 7),
                digits.substring(7, 11)
        );
    }
}
