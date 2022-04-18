package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.entity.dto.CategoryDto;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.entity.enums.TransactionType;
import com.dzvonik.cashflow.domain.entity.repository.TransactionRepository;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository;
import com.dzvonik.cashflow.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultTransactionServiceTest {

    @Mock
    TransactionRepository transactionRepository;

    TransactionService transactionService;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    DefaultUserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionService = new DefaultTransactionService(userService, transactionRepository);
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
        assertThat(transactionDto.getDate()).isEqualTo(transaction.getDate());
        assertThat(transactionDto.getAccount().getId()).isEqualTo(accountDto.getId());
        assertThat(transactionDto.getAccount().getTitle()).isEqualTo(accountDto.getTitle());
        assertThat(transactionDto.getCategory().getId()).isEqualTo(categoryDto.getId());
        assertThat(transactionDto.getCategory().getTitle()).isEqualTo(categoryDto.getTitle());
        assertThat(transactionDto.getComment()).isEqualTo("Test!");
    }

    @Test
    void getAllTransactions_WhenCall_ThenReturnDtoList() {
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
        List<Transaction> transactions = List.of(transaction);
        Account account = Account.builder()
                .id(1L)
                .title("Cash")
                .currency("RUB")
                .balance(new BigDecimal("153.10"))
                .categories(List.of(mock(Category.class)))
                .transactions(transactions)
                .build();
        List<Account> accounts = List.of(account);
        User user = User.builder()
                .id(1L)
                .name("John")
                .baseCurrency("RUB")
                .accounts(accounts)
                .build();

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(mock(User.class)));
        when(transactionRepository.findAllByAccountInAndDateAfterOrderByDateDesc(accounts, LocalDate.now())).thenReturn(transactions);

        List<TransactionDto> transactionDtos = transactionService.getAllTransactions();
        TransactionDto transactionDto = transactionDtos.get(0);

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

}
