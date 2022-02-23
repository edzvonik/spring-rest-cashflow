package com.dzvonik.cashflow.controller;

import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/api/v1/transactions")
    public List<TransactionDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

}
