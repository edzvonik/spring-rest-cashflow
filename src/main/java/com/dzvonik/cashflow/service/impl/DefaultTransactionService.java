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
        List<Account> accounts = user.getAccounts();

        return transactionRepository.findAllByAccountInAndDateAfterOrderByDateDesc(accounts, LocalDate.now()).stream()
                .map(this::buildTransactionDto)
                .collect(Collectors.toList());
    }

    private TransactionDto buildTransactionDto(Transaction transaction) {
        Account account = transaction.getAccount();
        AccountDto accountDto = new AccountDto(account.getId(), account.getTitle());
        Category category = transaction.getCategory();
        CategoryDto categoryDto = null;
        if (category != null) {
            categoryDto = new CategoryDto(category.getId(), category.getTitle());
        }

        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .comment(transaction.getComment())
                .account(accountDto)
                .category(categoryDto)
                .build();
    }

}
