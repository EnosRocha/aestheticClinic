package com.example.aestheticClinic.interfaces.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/token")
    public ResponseEntity<Map<String, Object>> home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            Map<String, Object> response = new java.util.HashMap<>();
            response.put("message", "Bem-vindo!");
            response.put("username", authentication.getName());
            response.put("authorities", authentication.getAuthorities().toString());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
