package com.dzvonik.cashflow.domain.entity.dto;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionDto {

    private final Long id;
    private final BigDecimal amount;
    private final TransactionType type;
    private final LocalDate date;
    private final String comment;
    private final AccountDto account;
    private final CategoryDto category;

}

