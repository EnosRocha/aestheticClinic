package com.example.aestheticClinic.application.mapper;

import com.example.aestheticClinic.application.dto.CreateNewClient;
import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.objectValue.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientApplicationMapper {

    @Mapping(target ="name", source = "name")
    @Mapping(target = "cellphoneNumber", expression = "java(new CellPhoneNumber(newClient.cellphoneNumber()))")
    @Mapping(target = "cpf", expression = "java(new CPF(newClient.cpf()))")
    @Mapping(target = "email", expression = "java(new Email(newClient.email()))")
    @Mapping(target = "role", expression = "java(Roles.CLIENT)")
    @Mapping(target = "adress", expression = "java(newClient.adress().stream().map(a -> new Adress(a.street(), a.number(), a.neighborhood(), a.city(), a.state(), a.cep())).toList())")
    Client toClient(CreateNewClient newClient);


}
