package com.example.aestheticClinic.infrastructure.persistence.jpa.client;

import com.example.aestheticClinic.application.mapper.ClientApplicationMapper;
import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.objectValue.CPF;
import com.example.aestheticClinic.domain.objectValue.CellPhoneNumber;
import com.example.aestheticClinic.domain.objectValue.Email;
import com.example.aestheticClinic.domain.repository.ClientRespority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRespority {

    private ClientApplicationMapper

    @Override
    public Optional<Client> findByCpf(CPF cpf) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findByEmail(Email email) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findByCellPhoneNumber(CellPhoneNumber number) {
        return Optional.empty();
    }
}
