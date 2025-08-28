package com.example.aestheticClinic.domain.repository;

import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.objectValue.CPF;
import com.example.aestheticClinic.domain.objectValue.CellPhoneNumber;
import com.example.aestheticClinic.domain.objectValue.Email;

import java.util.List;
import java.util.Optional;

public interface ClientRespority {

    Optional<Client> findByCpf(CPF cpf);
    Optional<Client> findByEmail(Email email);
    List<Client> findByCellphoneNumber(CellPhoneNumber number);
    Client save(Client client);
}
