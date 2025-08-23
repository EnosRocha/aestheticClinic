package com.example.aestheticClinic.security;


import com.example.aestheticClinic.domain.entity.User;
import com.example.aestheticClinic.domain.objectValue.Email;
import com.example.aestheticClinic.domain.objectValue.Roles;
import com.example.aestheticClinic.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminConfig {

    @Bean
    CommandLineRunner loadAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByName("admin").isEmpty()) {
                User admin = new User("admin", new Email("admin@gmail.com"), passwordEncoder.encode("admin"), Roles.ADMIN);
                userRepository.save(admin);
            }else{
                System.out.printf("admin already exists");
            }
        };
    }


}
