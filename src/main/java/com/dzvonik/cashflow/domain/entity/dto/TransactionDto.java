package com.dzvonik.cashflow.domain.entity.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionDto {

    private final Long id;

    private final BigDecimal amount;

    private final LocalDate date;

    private final String comment;

    private final AccountDto account;

    private final CategoryDto category;

}

