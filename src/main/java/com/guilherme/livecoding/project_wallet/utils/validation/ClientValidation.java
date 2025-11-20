package com.guilherme.livecoding.project_wallet.utils.validation;

import com.guilherme.livecoding.project_wallet.dto.request.CreateClientRequest;
import com.guilherme.livecoding.project_wallet.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ClientValidation {
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

    public void validateBody(CreateClientRequest request) {
        validateIdClient(request.getId());
        validateName(request.getName());
        validateBalance(request.getBalance());
    }


    public void validateExists(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Client not found with id: " + id);
        }

    }

}
