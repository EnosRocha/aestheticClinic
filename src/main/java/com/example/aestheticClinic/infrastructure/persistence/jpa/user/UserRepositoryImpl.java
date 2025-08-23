package com.example.aestheticClinic.infrastructure.persistence.jpa.user;

import com.example.aestheticClinic.domain.entity.User;
import com.example.aestheticClinic.domain.objectValue.Email;
import com.example.aestheticClinic.domain.repository.UserRepository;
import com.example.aestheticClinic.infrastructure.mappers.UserEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserEntityMapper userEntityMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return userJpaRepository.findByEmail(email.getValue()).map(userEntityMapper::toUser);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userJpaRepository.findByName(name).map(userEntityMapper::toUser);
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userJpaRepository.save(userEntity);
    }
}
