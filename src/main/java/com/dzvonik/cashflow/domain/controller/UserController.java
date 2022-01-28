package com.dzvonik.cashflow.domain.controller;

import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/getAllTransactions")
    public List<TransactionDto> getAllTransactions(@PathVariable("userId") Long id) {
        return userService.getAllTransactions(id);
    }

    @GetMapping("/{userId}/getAllAccounts")
    public List<TransactionDto> getAllAccounts(@PathVariable("userId") Long id) {
        return userService.getAllTransactions(id);
    }
}
