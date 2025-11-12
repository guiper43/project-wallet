package com.guilherme.livecoding.project_wallet.service;

import com.guilherme.livecoding.project_wallet.model.Client;
import com.guilherme.livecoding.project_wallet.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repository;

    private void validateClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client body must not be null");
        }

        if (client.getName() == null || client.getName().isBlank()) {
throw new IllegalArgumentException("Client name must not be empty");
        }
        if (client.getBalance() == null){
            throw new IllegalArgumentException("Client balance must not be null");
        }
        if (client.getBalance().compareTo(BigDecimal.ZERO) < 0){
throw new IllegalArgumentException("Client balance must not be negative");
        }

    }
public Client createClient(Client client){
        validateClient(client);
        return repository.save(client)
}

}
