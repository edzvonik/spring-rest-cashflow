package com.dzvonik.cashflow.domain.entity.dto;

import java.math.BigDecimal;
import java.util.List;

public class AccountDto {

    private Long id;

    private String title;

    private String currency;

    private BigDecimal balance;

    private List<CategoryDto> categories;

    private List<TransactionDto> transactions;

}

