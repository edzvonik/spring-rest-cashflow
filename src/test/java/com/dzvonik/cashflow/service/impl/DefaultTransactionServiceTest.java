package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.entity.enums.TransactionType;
import com.dzvonik.cashflow.domain.entity.repository.TransactionRepository;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository;
import com.dzvonik.cashflow.service.TransactionService;
import com.dzvonik.cashflow.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class DefaultTransactionServiceTest {

    TransactionRepository transactionRepository;
    TransactionService transactionService;
    UserRepository userRepository;
    UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        transactionRepository = Mockito.mock(TransactionRepository.class);
        userService = new DefaultUserService(userRepository);
    }

    @Test
    void getTransaction_WhenCall_ThenReturnDto() {
        Transaction t1 = Transaction.builder()
                .id(2L)
                .amount(new BigDecimal("1023.56"))
                .type(TransactionType.EXPENSE)
                .date(LocalDate.of(2022, 1, 6))
                .comment("Test!")
                .build();

        when(transactionRepository.getById(t1.getId())).thenReturn(t1);
        transactionService = new DefaultTransactionService(userService, transactionRepository);

        TransactionDto transactionDto = transactionService.getTransaction(2L);

        assertThat(transactionDto.getId()).isEqualTo(2L);
        assertThat(transactionDto.getAmount()).isEqualTo(new BigDecimal("1023.56"));
        assertThat(transactionDto.getType()).isEqualTo(TransactionType.EXPENSE);
        assertThat(transactionDto.getDate()).isEqualTo(LocalDate.of(2022, 1, 6));
        assertThat(transactionDto.getComment()).isEqualTo("Test!");
    }

    @Test
    void getAllTransactions_WhenCall_ThenReturnDtoList() {
        // Возвращает TransactionDto list
//        // TransactionDto не позднее 3х месяцев от текущей даты
//        MockitoAnnotations.openMocks(this);
//        List<TransactionDto> mockDtoList = mockDtoList();
//        when(transactionService.getAllTransactions()).thenReturn();
//
//        List<TransactionDto> transactionDtos = transactionService.getAllTransactions();
//
//
//        assertThat(transactionService.getAllTransactions()).containsExactlyInAnyOrderElementsOf(transactionDtos);
    }

}
