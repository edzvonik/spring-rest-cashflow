package com.dzvonik.cashflow.domain.entity.repository.UserRepository;

import com.dzvonik.cashflow.domain.entity.Account;

import java.util.List;

public interface CustomizedUserRepository {

    List<Account> getAllAccounts();

}
