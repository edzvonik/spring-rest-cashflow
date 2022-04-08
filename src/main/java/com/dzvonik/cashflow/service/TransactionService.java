package com.dzvonik.cashflow.service;

import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto getTransaction(Long id);

    List<TransactionDto> getAllTransactions();

}
