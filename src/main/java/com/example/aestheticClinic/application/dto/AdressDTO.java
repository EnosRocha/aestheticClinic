package com.example.aestheticClinic.application.dto;

import jakarta.validation.constraints.NotBlank;

public record AdressDTO(
        @NotBlank String street,
        @NotBlank String number,
        @NotBlank String neighborhood,
        @NotBlank String city,
        @NotBlank String state,
        @NotBlank String cep
) {
}
