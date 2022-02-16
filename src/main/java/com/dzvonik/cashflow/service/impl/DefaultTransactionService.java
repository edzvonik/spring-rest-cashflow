package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.entity.dto.CategoryDto;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.entity.repository.TransactionRepository;
import com.dzvonik.cashflow.service.TransactionService;
import com.dzvonik.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultTransactionService implements TransactionService {

    private final UserService userService;
    private final TransactionRepository transactionRepository;

    @Override
    public List<TransactionDto> getAllTransactions() {
        User user = userService.getUser(1L);
        List<Account> accounts = user.getAccounts();
        LocalDate threeMonthAgo = LocalDate.now().minusMonths(3);
        List<Transaction> transactions = transactionRepository.findAllByAccountInAndDateAfter(accounts, threeMonthAgo);
        List<TransactionDto> transactionDtos = new ArrayList<>();

        for (Transaction transaction : transactions) {
            TransactionDto transactionDto = buildTransactionDto(transaction);
            transactionDtos.add(transactionDto);
        }

        return transactionDtos;
    }

    private TransactionDto buildTransactionDto(Transaction transaction) {
        Account account = transaction.getAccount();
        Category category = Optional.of(transaction.getCategory()).orElse(null);

        return TransactionDto.builder()
                            .id(transaction.getId())
                            .amount(transaction.getAmount())
                            .date(transaction.getDate())
                            .comment(transaction.getComment())
                            .account(new AccountDto(account.getId(), account.getTitle()))
                            .category(new CategoryDto(category.getId(), category.getTitle()))
                            .build();
    }

}
