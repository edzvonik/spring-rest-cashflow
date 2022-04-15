package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.entity.dto.CategoryDto;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.entity.enums.TransactionType;
import com.dzvonik.cashflow.domain.entity.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultTransactionServiceTest {

    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    DefaultTransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTransaction_WhenCall_ThenReturnDto() {
        Transaction transaction = Transaction.builder()
                .id(2L)
                .amount(new BigDecimal("1023.56"))
                .type(TransactionType.EXPENSE)
                .date(LocalDate.of(2022, 1, 6))
                .comment("Test!")
                .account(mock(Account.class))
                .category(mock(Category.class))
                .build();
        CategoryDto categoryDto = new CategoryDto(transaction.getCategory().getId(), transaction.getCategory().getTitle());
        AccountDto accountDto = new AccountDto(transaction.getAccount().getId(), transaction.getAccount().getTitle());
        when(transactionRepository.findById(2L)).thenReturn(Optional.of(transaction));

        TransactionDto transactionDto = transactionService.getTransaction(2L);

        assertThat(transactionDto.getId()).isEqualTo(2L);
        assertThat(transactionDto.getAmount()).isEqualTo(new BigDecimal("1023.56"));
        assertThat(transactionDto.getType()).isEqualTo(TransactionType.EXPENSE);
        assertThat(transactionDto.getDate()).isEqualTo(LocalDate.of(2022, 1, 6));
        assertThat(transactionDto.getAccount().getId()).isEqualTo(accountDto.getId());
        assertThat(transactionDto.getAccount().getTitle()).isEqualTo(accountDto.getTitle());
        assertThat(transactionDto.getCategory().getId()).isEqualTo(categoryDto.getId());
        assertThat(transactionDto.getCategory().getTitle()).isEqualTo(categoryDto.getTitle());
        assertThat(transactionDto.getComment()).isEqualTo("Test!");
    }

    @Test
    void getAllTransactions_WhenCall_ThenReturnDtoList() {

    }

}
