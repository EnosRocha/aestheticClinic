package com.example.aestheticClinic.application.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CreateNewClient(
        @NotBlank String name,
        @NotBlank String cellphoneNumber,
        @NotBlank String cpf,
        @NotBlank String email,
        List<AdressDTO>adress
) {
}
