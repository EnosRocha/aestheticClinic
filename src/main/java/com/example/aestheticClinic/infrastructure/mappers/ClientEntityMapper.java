package com.example.aestheticClinic.infrastructure.mappers;

import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.infrastructure.persistence.jpa.client.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    @Mapping(target ="name", source = "client.getName()")
    @Mapping(target = "cellphoneNumber", source = "client.getCellphoneNumber()")
    @Mapping(target = "cpf", source = "client.getCpf()")
    @Mapping(target = "email", source = "client.getEmail()")
    @Mapping(target = "role", source = "client.getRole()")
    @Mapping(target = "adress", expression = "java(client.getAdress().stream().map(a -> new AdressEmbeddable(a.street(), a.number(), a.neighborhood(), a.city(), a.state(), a.cep())).toList())")
    ClientEntity toEntity(Client client);



}
