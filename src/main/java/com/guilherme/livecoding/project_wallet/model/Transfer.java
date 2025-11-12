package com.guilherme.livecoding.project_wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    private long originId;
    private long destinationId;
    private BigDecimal amount;
private LocalDate timestamp;

}
