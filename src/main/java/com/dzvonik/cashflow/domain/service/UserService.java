package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;

import java.util.List;

public interface UserService {

    List<TransactionDto> getAllTransactions(Long id);

    List<Account> getAllAccounts(Long id);

    User findById(Long id);

}
