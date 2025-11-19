package com.guilherme.livecoding.project_wallet.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ClientResponse {
    private Long id;
    private String name;
    private BigDecimal balance;
}
