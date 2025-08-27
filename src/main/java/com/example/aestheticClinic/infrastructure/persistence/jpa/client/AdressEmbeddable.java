package com.example.aestheticClinic.infrastructure.persistence.jpa.client;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressEmbeddable {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;
}
