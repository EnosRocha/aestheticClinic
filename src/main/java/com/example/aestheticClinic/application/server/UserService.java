package com.example.aestheticClinic.application.server;

import com.example.aestheticClinic.application.dto.CreateNewUserDto;
import com.example.aestheticClinic.application.mapper.UserApplicationMapper;
import com.example.aestheticClinic.domain.entity.User;
import com.example.aestheticClinic.domain.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserApplicationMapper userApplicationMapper;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public void execute(CreateNewUserDto createNewUserDto) {
        String encodedPassword = passwordEncoder.encode(createNewUserDto.password());
        User user = userApplicationMapper.toUser(createNewUserDto, encodedPassword);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name)
                .map(u -> org.springframework.security.core.userdetails.User.builder()
                        .username(u.getName())
                        .password(u.getPassword())
                        .roles(u.getRole().toString())
                        .build()).orElseThrow(() -> new EntityExistsException("entidade nao encontrada"));
    }
}
