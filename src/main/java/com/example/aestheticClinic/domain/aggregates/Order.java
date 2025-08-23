package com.example.aestheticClinic.domain.aggregates;

import com.example.aestheticClinic.domain.entity.Client;
import com.example.aestheticClinic.domain.entity.Packages;
import com.example.aestheticClinic.domain.objectValue.Descount;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long orderId;
    private Client client;
    private List<Packages> packages;
    private BigDecimal finalOrderValue;
    private Descount desconto;

    public Order(Long orderId, Client client, List<Packages> packages, BigDecimal finalOrderValue, Descount desconto) {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId cant be null");
        }
        this.orderId = orderId;
        this.client = client;
        this.packages = packages;
        this.desconto = desconto;

        BigDecimal rawValue = calculateFinalValue(packages);
        this.finalOrderValue = calculateFinalValueWithDescount(rawValue, desconto);
    }

    public BigDecimal calculateFinalValue(List<Packages> packages) {
        BigDecimal result = new BigDecimal(0);
        return packages.stream().map(Packages::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateFinalValueWithDescount(BigDecimal rawValue, Descount desconto) {
        if (desconto.getDescountType().equals(DescountType.VALUE)) {
            return rawValue.subtract(desconto.getValue());
        }
        if (desconto.getDescountType().equals(DescountType.PERCENTAGE)) {
            BigDecimal percentage = desconto.getValue().divide(new BigDecimal(100));
            BigDecimal discountAMount = rawValue.multiply(percentage);
            return rawValue.subtract(discountAMount);

        }
        return rawValue;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Client getClient() {
        return client;
    }

    public List<Packages> getPackages() {
        return packages;
    }

    public BigDecimal getFinalOrderValue() {
        return finalOrderValue;
    }

    public Descount getDesconto() {
        return desconto;
    }
}
