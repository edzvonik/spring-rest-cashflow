package com.dzvonik.cashflow.domain.entity.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDto {

    private final Long id;
    private final String title;
    private final String currency;
    private final BigDecimal balance;
    private final List<CategoryDto> categories;
    private final List<TransactionDto> transactions;

}
