package com.guilherme.livecoding.project_wallet.client.utils.validation;

import com.guilherme.livecoding.project_wallet.utils.validation.ClientValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ClientValidationTest {
    private ClientValidation validator;

    @BeforeEach
    void setup() {
        validator = new ClientValidation();
    }

    @Test
    void shouldValidateIdWhenIdIsValid() {
        assertDoesNotThrow(() -> validator.validateIdClient(1L));
    }

    @Test
    void shouldInvalidateIdWhenIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateIdClient(null));
    }

    @Test
    void shouldInvalidateIdWhenIdIsNegativeOrZero() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateIdClient(0L));
        assertThrows(IllegalArgumentException.class, () -> validator.validateIdClient(-11L));
    }

    @Test
    void shouldValidateNameWhenNameIsValid() {
        assertDoesNotThrow(() -> validator.validateName("Guilherme"));
    }

    @Test
    void shouldInvalidateNameWhenNameIsNullOrBlank() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateName(null));
        assertThrows(IllegalArgumentException.class, () -> validator.validateName(""));
    }

    @Test
    void shouldValidateBalanceWhenBalanceIsValid() {
        assertDoesNotThrow(() -> validator.validateBalance(new BigDecimal("5000.00")));
    }

    @Test
    void shouldInvalidateBalanceWhenBalanceIsNull() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateBalance(null));
    }

    @Test
    void shouldInvalidateBalanceWhenBalanceIsNegative() {
        BigDecimal balanceNegative = new BigDecimal("-550.00");
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateBalance(balanceNegative));
    }


}