package com.dzvonik.cashflow.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String title;
    private List<TransactionDto> transactions;

}

