package com.guilherme.livecoding.project_wallet.utils;

import com.guilherme.livecoding.project_wallet.model.Client;
import com.guilherme.livecoding.project_wallet.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class ValidationClient {
    private final ClientRepository repository;

    public void validateIdClient(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Client id must not be null");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Client id must be greater than zero");
        }

    }

    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Client name must not be empty");
        }
    }

    public void validateBalance(BigDecimal balance) {
        if (balance == null) {
            throw new IllegalArgumentException("Client balance must not be null");
        }

        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Client balance must not be negative");
        }

    }

    public void validateBody(Client client) {
        validateIdClient(client.getId());
        validateName(client.getName());
        validateBalance(client.getBalance());
    }


    public void validateExists(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Client not found with id: " + id);
        }

    }

}
