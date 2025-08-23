package com.example.aestheticClinic.domain.repository;

import com.example.aestheticClinic.domain.entity.User;
import com.example.aestheticClinic.domain.objectValue.Email;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(Email email);
    Optional<User> findByName(String name);
    void save(User user);

}
