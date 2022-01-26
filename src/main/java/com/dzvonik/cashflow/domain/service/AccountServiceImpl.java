package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.entity.mapper.AccountMapper;
import com.dzvonik.cashflow.domain.entity.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public List<AccountDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AccountDto findById(Long id) {
        return accountRepository.findById(id)
                .map(AccountMapper.INSTANCE::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Account with id=" + id + "not found"));
    }



}
