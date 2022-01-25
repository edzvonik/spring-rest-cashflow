package com.dzvonik.cashflow.domain.controller;

import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.service.AccountService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountDto> findAll() {
        return accountService.findAll();
    }

    @GetMapping(value = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto findById(@PathVariable("accountId") Long id) {
        return accountService.findById(id);
    }

}
