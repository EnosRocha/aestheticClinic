package com.example.aestheticClinic.application.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateNewUserDto(
        @NotBlank @Size(min = 5, max = 100) String name,
        @NotBlank @Email @Column(unique = true) String email,
        @NotBlank String role,
        @NotBlank @Size(min = 5, max = 100) String password) {
}
