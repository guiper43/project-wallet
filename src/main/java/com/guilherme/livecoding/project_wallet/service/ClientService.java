package com.guilherme.livecoding.project_wallet.service;

import com.guilherme.livecoding.project_wallet.dto.request.CreateClientRequest;
import com.guilherme.livecoding.project_wallet.dto.request.UpdateClientRequest;
import com.guilherme.livecoding.project_wallet.dto.response.ClientResponse;
import com.guilherme.livecoding.project_wallet.model.Client;
import com.guilherme.livecoding.project_wallet.repository.ClientRepository;
import com.guilherme.livecoding.project_wallet.utils.map.ClientMapper;
import com.guilherme.livecoding.project_wallet.utils.validation.ClientValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repository;
    private final ClientValidation validator;


    public ClientResponse create(CreateClientRequest request) {
        validator.validateBody(request);
        ensureClientDoesNotExistsById(request.getId());
        var client = ClientMapper.mappingToModel(request);
        var created = repository.save(client);
        return ClientMapper.mappingToDto(created);
    }

    private Client findClientById(Long id) {
        validator.validateIdClient(id);
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
    }

    public ClientResponse getClientById(Long id) {
        var client = findClientById(id);
        return ClientMapper.mappingToDto(client);
    }

    public List<ClientResponse> getAllClients() {
        return repository.findall().stream()
                .map(ClientMapper::mappingToDto).toList();
    }

    public void deleteClient(Long id) {
        validator.validateIdClient(id);
        ensureClientExistsById(id);
        repository.deleteClient(id);
    }

    public ClientResponse updateClient(Long id, UpdateClientRequest request) {
        validator.validateIdClient(id);
        validator.validateName(request.getName());
        var clientExisting = findClientById(id);
        var clientUpdated = Client.builder()
                .id(clientExisting.getId())
                .name(request.getName())
                .balance(clientExisting.getBalance())
                .build();
        var result = repository.save(clientUpdated);
        return ClientMapper.mappingToDto(result);
    }

    public void ensureClientExistsById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Client not found with id: " + id);
        }
    }

    private void ensureClientDoesNotExistsById(Long id) {
        if (repository.existsById(id)) {
            throw new IllegalStateException("Client already exists");
        }
    }

}
