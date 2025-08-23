package com.example.aestheticClinic.infrastructure.persistence.jpa.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByCpf(String cpf);
    Optional<ClientEntity> findByEmail(String email);
    Optional<ClientEntity> findByCellPhoneNumber(String number);
}
