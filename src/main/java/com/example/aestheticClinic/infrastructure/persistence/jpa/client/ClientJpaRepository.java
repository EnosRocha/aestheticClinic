package com.example.aestheticClinic.infrastructure.persistence.jpa.client;

import com.example.aestheticClinic.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface ClientJpaRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByCpf(String cpf);
    Optional<ClientEntity> findByEmail(String email);
    Optional<ClientEntity> findByCellphoneNumber(String number);
    ClientEntity save(ClientEntity client);
}
