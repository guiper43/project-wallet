package com.guilherme.livecoding.project_wallet.utils;

import com.guilherme.livecoding.project_wallet.model.Client;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidationClient {
    private void validateClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client body must not be null");
        }

        if (client.getName() == null || client.getName().isBlank()) {
            throw new IllegalArgumentException("Client name must not be empty");
        }

        if (client.getBalance() == null) {
            throw new IllegalArgumentException("Client balance must not be null");
        }

        if (client.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Client balance must not be negative");
        }

    }

    public void validateIdClient(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Client id must not be null");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Client id must be greater than zero");
        }
    }
}
