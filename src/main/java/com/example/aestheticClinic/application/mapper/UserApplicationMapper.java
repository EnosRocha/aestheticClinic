package com.example.aestheticClinic.application.mapper;

import com.example.aestheticClinic.application.dto.CreateNewUserDto;
import com.example.aestheticClinic.domain.entity.User;
import com.example.aestheticClinic.domain.objectValue.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserApplicationMapper {


    @Mapping(target = "email",source = "createNewUserDto.email", qualifiedByName = "stringtoemail")
    @Mapping(target = "password", source = "encodedPassword")
    @Mapping(target = "role", expression = "java(Roles.valueOf(createNewUserDto.role().toUpperCase()))")
    User toUser(CreateNewUserDto createNewUserDto, String encodedPassword);




    @Named("stringtoemail")
    default Email toEmail(String email){
        return new Email(email);
    }

}
