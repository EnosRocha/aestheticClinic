package com.example.aestheticClinic.domain.objectValue;

import java.util.Objects;

public class Email {
    private String value;

    public Email(String value) {
        Objects.requireNonNull(value, "email cant be null");
        if(!value.matches("^[\\w.-]+@[a-z]{2,}\\.[a-z]{2,}$")){
            throw new IllegalArgumentException("email format doesnt matches");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
