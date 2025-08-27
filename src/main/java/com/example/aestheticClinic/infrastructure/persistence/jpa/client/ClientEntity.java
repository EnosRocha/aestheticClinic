package com.example.aestheticClinic.infrastructure.persistence.jpa.client;

import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.objectValue.Adress;
import com.example.aestheticClinic.domain.objectValue.CPF;
import com.example.aestheticClinic.domain.objectValue.CellPhoneNumber;
import com.example.aestheticClinic.domain.objectValue.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "client_entity")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotNull
    private UUID clientId;

    @NotBlank
    private String name;

    @NotBlank
    private String cellphoneNumber;

    @NotBlank
    private String cpf;

    @NotBlank
    private String email;


    @ElementCollection
    @CollectionTable(
            name = "client_adress",
            joinColumns = @JoinColumn(name = "client_id")
    )
    private List<AdressEmbeddable> adress;

    private String role;


}
