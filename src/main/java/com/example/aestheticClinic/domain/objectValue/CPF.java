package com.example.aestheticClinic.domain.objectValue;

import java.util.Objects;

public class CPF {
    private String number;

    public String getNumber() {
        return number;
    }

    public CPF(String number) {
        Objects.requireNonNull(number, "CPF number cant be null");
        if (!number.matches("^\\d{3}[\\s.]?\\d{3}[\\s.]?\\d{3}[\\s-]?\\d{2}$")) {
            throw new IllegalArgumentException("cpf format doesnt matches");
        }

        this.number = number;
    }
}
