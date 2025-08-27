package com.example.aestheticClinic.application.server;

import com.example.aestheticClinic.application.dto.CreateNewClient;
import com.example.aestheticClinic.application.exception.ClientAlreadyExistsException;
import com.example.aestheticClinic.application.mapper.ClientApplicationMapper;
import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.objectValue.CPF;
import com.example.aestheticClinic.domain.repository.ClientRespority;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRespority clientRespority;
    private final ClientApplicationMapper clientApplicationMapper;

    @Transactional
    public Client createNewClient(CreateNewClient createNewClient) {
        CPF cpf = new CPF(createNewClient.cpf());
        if (clientRespority.findByCpf(cpf).isPresent()) {
            throw new ClientAlreadyExistsException("client already exists");
        }

        Client client = clientApplicationMapper.toClient(createNewClient);
        String number = client.getCellphoneNumber().toString();
        System.out.println("[" + number + "]");
        System.out.println("[" + number + "]");
        System.out.println("[" + number + "]");
        System.out.println("[" + number + "]");

        return clientRespority.save(client);
    }
}
