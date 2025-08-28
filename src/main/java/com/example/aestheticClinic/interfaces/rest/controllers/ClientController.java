package com.example.aestheticClinic.interfaces.rest.controllers;

import com.example.aestheticClinic.application.dto.CreateNewClient;
import com.example.aestheticClinic.application.server.ClientService;
import com.example.aestheticClinic.domain.entity.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Client>> getClientByCPForCellPhoneNumberOrName(@RequestParam(required = false)String cpf,
                                                                        @RequestParam(required = false)String cellphonenumber,
                                                                        @RequestParam(required = false)String email){
        List<Client> client = clientService.getUser(cpf,cellphonenumber,email);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

}
