package com.guilherme.livecoding.project_wallet.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateClientRequest {
private Long id;
private String name;
private BigDecimal balance;

}
