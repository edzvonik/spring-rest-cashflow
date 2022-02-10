package com.dzvonik.cashflow.domain.entity.repository;

import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.User;

import java.util.List;

public interface TransactionRepositoryCustom {

    List<Transaction> findAllByLastThreeMonthAndUser(User user);

}
