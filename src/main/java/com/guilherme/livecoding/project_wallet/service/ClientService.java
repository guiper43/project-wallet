package com.guilherme.livecoding.project_wallet.service;

import com.guilherme.livecoding.project_wallet.model.Client;
import com.guilherme.livecoding.project_wallet.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repository;



    public Client createClient(Client client) {
        validateClient(client);
        return repository.save(client);
    }

    public Client getClientById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Client id must not be null");
        }

        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
    }

    public List<Client> getAllClients() {
        return repository.findall()
                .stream().toList();
    }


}
