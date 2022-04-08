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
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionDto getTransaction(@PathVariable(name = "id") Long id) {
        return transactionService.getTransaction(id);
    }

}
