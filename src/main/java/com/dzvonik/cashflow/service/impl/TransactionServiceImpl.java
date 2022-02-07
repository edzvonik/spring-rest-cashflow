package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.service.TransactionService;
import com.dzvonik.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final UserService userService;

    @Override
    @Transactional
    public List<TransactionDto> findAllTransactionsByUserId(Long id) {
        User user = userService.findById(id);

        List<Account> accounts = user.getAccounts();

        List<Category> categories = accounts.stream()
                .map(Account::getCategories)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<TransactionDto> transactions = categories.stream()
                .map(Category::getTransactions)
                .flatMap(List::stream)
                .map(t -> TransactionDto.builder()
                        .id(t.getId())
                        .amount(t.getAmount())
                        .type(t.getType())
                        .date(t.getDate())
                        .comment(t.getComment())
                        .build())
                .collect(Collectors.toList());

        return transactions;
    }

}
