package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.entity.repository.AccountRepository;
import com.dzvonik.cashflow.domain.entity.repository.CategoryRepository;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<TransactionDto> getAllTransactionsById(Long id) {
        return null;
    }

}
