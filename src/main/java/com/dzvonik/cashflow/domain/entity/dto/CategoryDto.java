package com.dzvonik.cashflow.domain.entity.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDto {

    private final Long id;
    private final String title;
    private final List<TransactionDto> transactions;

}

