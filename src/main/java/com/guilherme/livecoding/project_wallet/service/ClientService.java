package com.guilherme.livecoding.project_wallet.service;

import com.guilherme.livecoding.project_wallet.model.Client;
import com.guilherme.livecoding.project_wallet.repository.ClientRepository;
import com.guilherme.livecoding.project_wallet.utils.ValidationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repository;
    private final ValidationClient validator;


    public Client create(Client client) {
        validator.validateBody(client);
        return repository.save(client);
    }

    public Client getClientById(Long id) {
        validator.validateIdClient(id);
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
    }

    public List<Client> getAllClients() {
        return repository.findall()
                .stream().toList();
    }

    public void deleteClient(Long id) {
        validator.validateIdClient(id);
        validator.validateExists(id);
        repository.deleteClient(id);
    }

    public Client updateClient(Long id, Client body) {
        validator.validateIdClient(id);
        var clientExisting = getClientById(id);
        String nameUpdated = body.getName();
        validator.validateName(nameUpdated);
        clientExisting.setName(nameUpdated);
        return repository.save(clientExisting);
    }

}
