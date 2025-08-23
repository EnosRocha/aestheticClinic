package com.example.aestheticClinic.domain.entity;

import com.example.aestheticClinic.domain.objectValue.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Client {

    private String name;
    private CellPhoneNumber cellphoneNumber;
    private CPF cpf;
    private Email email;
    private List<Adress> adress;
    private Roles role;

    public Client(String name, CellPhoneNumber cellphoneNumber, CPF cpf, Email email, List<Adress> adress, Roles role) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("name cant be null or empty");
        }

        this.name = name;
        this.cellphoneNumber = cellphoneNumber;
        this.cpf = cpf;
        this.email = email;
        this.adress = adress;
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public CellPhoneNumber getCellphoneNumber() {
        return cellphoneNumber;
    }

    public CPF getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public List<Adress> getAdress() {
        return adress;
    }

    public Roles getRole() {
        return role;
    }
}
