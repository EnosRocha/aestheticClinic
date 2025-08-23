package com.example.aestheticClinic.domain.objectValue;

import java.util.stream.Stream;

public class Adress {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String CEP;

    public Adress(String street, String number, String neighborhood, String city, String state, String CEP) {
        Stream.of(street, number, neighborhood, city, state, CEP)
                .forEach(field -> {
                            if (field == null || field.isEmpty()) {
                                throw new IllegalArgumentException("state,number,neighborhood,city,state or CEP cant be null or empty");
                            }
                            if (field.equals(CEP)) {
                                if (!field.matches("^d{2}[\\s-]?\\d{3}[\\s-]?\\d{3}$")) {
                                    throw new IllegalArgumentException("CEP format doesnt matches");
                                }
                            }
                        }
                );
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.CEP = CEP;
    }

    public String getStreet() {
        return street;
    }


    public String getNumber() {
        return number;
    }


    public String getNeighborhood() {
        return neighborhood;
    }


    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    public String getCEP() {
        return CEP;
    }


}
