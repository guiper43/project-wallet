package com.guilherme.livecoding.project_wallet.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    private Long id;
    private String name;
    private BigDecimal balance;
}
