package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;

import java.util.List;

public interface UserService {

    List<TransactionDto> getAllTransactionsById(Long id);

}
