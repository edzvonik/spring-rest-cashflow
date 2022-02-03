package com.dzvonik.cashflow.domain.entity.dto;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionDto {

    private final Long id;
    private final BigDecimal amount;
    private final TransactionType type;
    private final LocalDate date;
    private final String comment;
    private final AccountInfoDto accountInfo;
    private final CategoryInfoDto categoryInfo;

}

