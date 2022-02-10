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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultTransactionService implements TransactionService {

    private final UserService userService;

    private final TransactionRepository transactionRepository;

    @Override
    public List<TransactionDto> getAllTransactions() {
        User user = userService.getUser();
        List<Transaction> transactions = transactionRepository.findAllByLastThreeMonthAndUser(user);
        List<TransactionDto> transactionDtos = new ArrayList<>();

        for (Transaction transaction : transactions) {
            TransactionDto transactionDto = buildTransactionDto(transaction.getAccount(), transaction.getCategory(), transaction);
            transactionDtos.add(transactionDto);
        }

        return transactionDtos;
    }

    private TransactionDto buildTransactionDto(Account account, Category category, Transaction transaction) {
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
