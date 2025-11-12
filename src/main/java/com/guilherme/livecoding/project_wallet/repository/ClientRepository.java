package com.guilherme.livecoding.project_wallet.repository;

import com.guilherme.livecoding.project_wallet.model.Client;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ClientRepository {
    private Map<long, Client> clientes = new HashMap<>();

    public Client save(Client client) {
        clientes.put(client.getId(), client);
        return client;
    }

    public Optional<Client> findByIdd(long id) {
        return Optional.ofNullable(clientes.get(id));
    }

    public Collection<Client> findall() {
        return clientes.values();
    }

    public boolean existsById(long id) {
        return clientes.containsKey(id);
    }

}
