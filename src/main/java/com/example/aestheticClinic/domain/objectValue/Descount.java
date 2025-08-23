package com.example.aestheticClinic.domain.objectValue;

import com.example.aestheticClinic.domain.aggregates.DescountType;

import java.math.BigDecimal;

public class Descount {
    private final BigDecimal value;
    private final DescountType descountType;


    public Descount(BigDecimal value, DescountType descountType) {
        this.value = value;
        this.descountType = descountType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public DescountType getDescountType() {
        return descountType;
    }
}
