package com.dzvonik.cashflow.controller;

import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users/{userId}")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(value = "/transactions")
    public List<TransactionDto> findAllTransactions(@PathVariable("userId") Long id) {
        return transactionService.findAllTransactionsByUserId(id);
    }

}
