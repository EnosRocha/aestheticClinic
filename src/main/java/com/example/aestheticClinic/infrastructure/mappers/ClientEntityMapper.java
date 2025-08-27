package com.example.aestheticClinic.infrastructure.mappers;

import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.infrastructure.persistence.jpa.client.AdressEmbeddable;
import com.example.aestheticClinic.infrastructure.persistence.jpa.client.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, AdressEmbeddable.class})
public interface ClientEntityMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "cellphoneNumber", expression = "java(client.getCellphoneNumber().getNumber())")
    @Mapping(target = "cpf", expression = "java(client.getCpf().getNumber())")
    @Mapping(target = "email", expression = "java(client.getEmail().getValue())")
    @Mapping(target = "role", expression = "java(client.getRole().toString())")
    @Mapping(target = "adress", expression = "java(client.getAdress().stream()" +
            ".map(a -> new AdressEmbeddable(a.getStreet(), a.getNumber(), a.getNeighborhood(), a.getCity(), a.getState(), a.getCep()))" +
            ".collect(Collectors.toList()))")
    ClientEntity toEntity(Client client);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "cellphoneNumber", expression = "java(new CellPhoneNumber(client.getCellphoneNumber()))")
    @Mapping(target = "cpf", expression = "java(new CPF(client.getCpf()))")
    @Mapping(target = "email", expression = "java(new Email(client.getEmail()))")
    @Mapping(target = "role", expression = "java(Roles.valueOf(client.getRole()))")
    @Mapping(target = "adress", expression = "java(client.getAdress().stream()" +
            ".map(a -> new Adress(a.getStreet(), a.getNumber(), a.getNeighborhood(), a.getCity(), a.getState(), a.getCep()))" +
            ".collect(Collectors.toList()))")
    Client toDomain(ClientEntity client);
}