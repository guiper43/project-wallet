package com.guilherme.livecoding.project_wallet.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateClientRequest {
    private String name;
}
