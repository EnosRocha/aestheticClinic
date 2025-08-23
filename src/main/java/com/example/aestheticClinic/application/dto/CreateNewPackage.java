package com.example.aestheticClinic.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

public record CreateNewPackage(
        @NotBlank String name,
        @NotNull Integer numberOfSections,
        @Nullable Integer numberOfSectionsLeft,
        @NotNull BigDecimal value,
        @NotBlank @Size(min = 10, max = 300) String description

) {
}
