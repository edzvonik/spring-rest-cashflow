package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultTransactionServiceTest {

    @Test
    void getAllTransactions_WhenCall_ThenReturnDtoList() {
        TransactionService transactionService = mock(DefaultTransactionService.class);
        List<TransactionDto> transactionDtos = List.of(mock(TransactionDto.class));
        when(transactionService.getAllTransactions()).thenReturn(transactionDtos);
        assertThat(transactionService.getAllTransactions()).containsExactlyInAnyOrderElementsOf(transactionDtos);
    }

}
