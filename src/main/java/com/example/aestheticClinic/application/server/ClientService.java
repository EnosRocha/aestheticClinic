package com.example.aestheticClinic.application.server;

import com.example.aestheticClinic.application.dto.CreateNewClient;
import com.example.aestheticClinic.application.exception.ClientAlreadyExistsException;
import com.example.aestheticClinic.application.exception.ClientNotFoundException;
import com.example.aestheticClinic.application.mapper.ClientApplicationMapper;
import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.objectValue.CPF;
import com.example.aestheticClinic.domain.objectValue.CellPhoneNumber;
import com.example.aestheticClinic.domain.objectValue.Email;
import com.example.aestheticClinic.domain.repository.ClientRespority;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return clientRespority.save(client);
    }

    @Transactional
    public List<Client> getUser(String cpf, String cellphonenumber, String email) {


        if (cpf == null && cellphonenumber == null && email == null) {
            throw new ClientNotFoundException("at least one of parameters (CPF, Cellphonenumber or email) must be provided, the system cant find any client");
        }

        if (cpf != null) {
            return clientRespority.findByCpf(new CPF(cpf)).map(List::of).orElseThrow(() -> {
                throw new ClientNotFoundException("Client with this CPF not exists in the Data base");
            });
        } else if (cellphonenumber != null) {
            CellPhoneNumber cellPhoneNumberResponse = new CellPhoneNumber(cellphonenumber);
            List<Client> clienteByCellPhoneNumber = clientRespority.findByCellphoneNumber(cellPhoneNumberResponse);
            if (clienteByCellPhoneNumber.isEmpty()) {
                throw new ClientNotFoundException("THere are not clients in the Data base with this cellphone number");
            }
            return clienteByCellPhoneNumber;
        } else {
            return clientRespority.findByEmail(new Email(email)).map(List::of).orElseThrow(() -> {
                throw new ClientNotFoundException("Client with this CPF not exists in the Data base");
            });
        }

    }
}
