package com.petplace.catalog.domain.user;

import java.util.regex.Pattern;

public record Cnpj(String cnpj) {
    private static final String CNPJ_FORMATTED_REGEX = "\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}-\\d{2}";
    private static final String CNPJ_ONLY_NUMBERS_REGEX = "\\d{14}";

    private static final Pattern CNPJ_FORMATTED_PATTERN = Pattern.compile(CNPJ_FORMATTED_REGEX);
    private static final Pattern CNPJ_ONLY_NUMBERS_PATTERN = Pattern.compile(CNPJ_ONLY_NUMBERS_REGEX);

    public Cnpj(String cnpj) {
        String formattedCnpj = formatCnpj(cnpj);

        if(!CNPJ_FORMATTED_PATTERN.matcher(formattedCnpj).matches()) {
            throw new IllegalArgumentException("Invalid CNPJ: " + cnpj);
        }

        this.cnpj = formattedCnpj;
    }

    private static String formatCnpj(String cnpj) {
        String digits = cnpj.replaceAll("\\D", "");

        if(!CNPJ_ONLY_NUMBERS_PATTERN.matcher(digits).matches()) {
            throw new IllegalArgumentException("Invalid CNPJ: " + cnpj);
        }

        return String.format("%s.%s.%s/%s-%s",
                digits.substring(0, 2),
                digits.substring(2, 5),
                digits.substring(5, 8),
                digits.substring(8, 12),
                digits.substring(12, 14)
        );
    }
}
