package com.example.aestheticClinic.domain.repository;

import com.example.aestheticClinic.domain.aggregates.Order;
import com.example.aestheticClinic.domain.objectValue.CPF;
import com.example.aestheticClinic.domain.objectValue.CellPhoneNumber;
import com.example.aestheticClinic.domain.objectValue.Email;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findByOrderId(Long orderId);
    Optional<Order> findByClientCpf(CPF cpf);
    Optional<Order> finByClientCellPhoneNumber(CellPhoneNumber cellPhoneNumber);
    Optional<Order> findByClientEmail(Email email);
}
