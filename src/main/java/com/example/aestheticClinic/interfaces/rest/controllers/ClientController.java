package com.example.aestheticClinic.interfaces.rest.controllers;

import com.example.aestheticClinic.application.dto.CreateNewClient;
import com.example.aestheticClinic.application.server.ClientService;
import com.example.aestheticClinic.domain.entity.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createNewClient(@RequestBody @Valid CreateNewClient client){
        Client clientResponse = clientService.createNewClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }
}
