package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.entity.dto.CategoryDto;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.service.TransactionService;
import com.dzvonik.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultTransactionService implements TransactionService {

    private final UserService userService;

    @Override
    public List<TransactionDto> getAllTransactions() {
        User user = userService.getUser();
        List<Account> accounts = user.getAccounts();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Account account : accounts) {
            Map<Category, List<Transaction>> categoriesToTransactions = account.getCategories().stream()
                    .collect(Collectors.toMap(Function.identity(), Category::getTransactions));
            List<Transaction> accountTransactions = account.getTransactions();
            List<TransactionDto> accountCategoryCommonTransactions =
                    getCommonTransactions(account, categoriesToTransactions, accountTransactions);
            transactionDtos.addAll(accountCategoryCommonTransactions);
        }
        return transactionDtos;
    }

    private List<TransactionDto> getCommonTransactions(Account account, Map<Category, List<Transaction>> categoriesToTransactions, List<Transaction> accountTransactions) {
        List<Transaction> commonTransactions = new ArrayList<>(accountTransactions);
        List<TransactionDto> result = new ArrayList<>();
        for (Map.Entry<Category, List<Transaction>> entry : categoriesToTransactions.entrySet()) {
            commonTransactions.retainAll(entry.getValue());
            Category category = entry.getKey();
            for (Transaction transaction : commonTransactions) {
                TransactionDto transactionDto = buildTransaction(account, category, transaction);
                result.add(transactionDto);
            }
        }
        return result;
    }

    private TransactionDto buildTransaction(Account account, Category category, Transaction transaction) {
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
