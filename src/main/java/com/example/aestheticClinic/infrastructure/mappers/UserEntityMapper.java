package com.example.aestheticClinic.infrastructure.mappers;

import com.example.aestheticClinic.domain.entity.User;
import com.example.aestheticClinic.domain.objectValue.Email;
import com.example.aestheticClinic.infrastructure.persistence.jpa.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    @Mapping(target = "email", source = "email", qualifiedByName = "emailToString")
    UserEntity toEntity(User user);

    @Mapping(target = "email", source = "email", qualifiedByName = "stringToEmail")
    User toUser(UserEntity entity);

    @Named("emailToString")
    default String toString(Email email){
        return new String(email.getValue());
    }
    @Named("stringToEmail")
    default Email toEmail(String email){
        return new Email(email);
    }
}
