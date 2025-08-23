package com.example.aestheticClinic.domain.entity;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Packages {
    private Long packageId;
    private String name;
    private Integer numberOfSections;
    private Integer numberOfSectionsLeft;
    private BigDecimal value;
    private String description;

    public Packages(String name, Integer numberOfSections, BigDecimal value, String description, Integer numberOfSectionsLeft) {
        Stream.of(name, value, description).forEach(
                field -> {
                    if (field == null || ((String) field).isEmpty()) {
                        throw new IllegalArgumentException("name, value or description cant be null or empty");
                    }
                }
        );

        this.name = name;
        this.value = value;
        this.description = description;
        this.numberOfSectionsLeft = numberOfSectionsLeft;
    }

    public String getName() {
        return name;
    }

    public Long getPackageId() {
        return packageId;
    }

    public Integer getNumberOfSections() {
        return numberOfSections;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public Integer getNumberOfSectionsLeft() {
        return numberOfSectionsLeft;
    }
}
