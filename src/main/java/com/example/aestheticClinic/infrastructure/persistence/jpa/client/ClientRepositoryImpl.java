package com.example.aestheticClinic.infrastructure.persistence.jpa.client;

import com.example.aestheticClinic.application.mapper.ClientApplicationMapper;
import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.objectValue.CPF;
import com.example.aestheticClinic.domain.objectValue.CellPhoneNumber;
import com.example.aestheticClinic.domain.objectValue.Email;
import com.example.aestheticClinic.domain.repository.ClientRespority;
import com.example.aestheticClinic.infrastructure.mappers.ClientEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRespority {

    private final ClientEntityMapper clientEntityMapper;
    private final ClientJpaRepository clientJpaRepository;


    @Override
    public Optional<Client> findByCpf(CPF cpf) {

        return clientJpaRepository.findByCpf(cpf.getNumber()).map(clientEntityMapper::toDomain);
    }

    @Override
    public Optional<Client> findByEmail(Email email) {

        return clientJpaRepository.findByEmail(email.getValue()).map(clientEntityMapper::toDomain);
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = clientEntityMapper.toEntity(client);
        ClientEntity clientEntityResponse = clientJpaRepository.save(clientEntity);
        return clientEntityMapper.toDomain(clientEntityResponse);
    }

    @Override
    public List<Client> findByCellphoneNumber(CellPhoneNumber number) {
        return clientJpaRepository.findByCellphoneNumber(number.getNumber()).stream().map(clientEntityMapper::toDomain).collect(Collectors.toList());
    }
}
