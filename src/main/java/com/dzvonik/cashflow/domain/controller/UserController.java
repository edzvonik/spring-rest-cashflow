package com.dzvonik.cashflow.domain.controller;

import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{userId}/findAllTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDto> findAllTransactions(@PathVariable("userId") Long id) {
        return userService.findAllTransactions(id);
    }

}
