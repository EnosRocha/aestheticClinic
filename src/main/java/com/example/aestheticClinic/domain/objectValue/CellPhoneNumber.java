package com.example.aestheticClinic.domain.objectValue;

import java.util.Objects;

public class CellPhoneNumber {
    private String number;

    public CellPhoneNumber(String number) {
        Objects.requireNonNull(number,"cellphone number cant be null");
        if(!number.matches("^\\d{10,11}$")){
            throw new IllegalArgumentException("cellphone format doesnt matches");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
