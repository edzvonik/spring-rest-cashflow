package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.sun.istack.NotNull;

import java.util.List;

public interface AccountService {

    @NotNull
    List<AccountDto> findAll();

    @NotNull
    AccountDto findById(@NotNull Long id);

}
