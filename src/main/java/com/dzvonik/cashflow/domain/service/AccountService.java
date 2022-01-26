package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> findAll();

    AccountDto findById(Long id);

}
