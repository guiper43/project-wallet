package com.guilherme.livecoding.project_wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private long id;
    private String name;
    private BigDecimal balance;
}
