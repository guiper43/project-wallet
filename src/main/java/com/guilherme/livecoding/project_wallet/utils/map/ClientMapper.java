package com.guilherme.livecoding.project_wallet.utils.map;

import com.guilherme.livecoding.project_wallet.dto.request.CreateClientRequest;
import com.guilherme.livecoding.project_wallet.dto.response.ClientResponse;
import com.guilherme.livecoding.project_wallet.model.Client;

public class ClientMapper {
    public static Client mappingToModel(CreateClientRequest request) {
        return Client.builder()
                .id(request.getId())
                .name(request.getName())
                .balance(request.getBalance())
                .build();
    }

    public static ClientResponse mappingToDto(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .balance(client.getBalance())
                .build();
    }
}
