package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.repository.TransactionRepository;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository;
import com.dzvonik.cashflow.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultTransactionServiceTest {

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void getAllTransactions_WhenCall_ThenReturnAllTransactions() {
        // 1. Создать юзера

        // 2. Добавить юзера, несколько счетов, категорий, транзакций

        // 3. Получить их через getAllTransaction и сравнить с тем, что клали
    }

}
