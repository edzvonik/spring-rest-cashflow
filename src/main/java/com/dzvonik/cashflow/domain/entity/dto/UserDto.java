package com.dzvonik.cashflow.domain.entity.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {

    private final Long id;
    private final String name;
    private final String email;
    private final String baseCurrency;
    private final List<AccountDto> accounts;

}

