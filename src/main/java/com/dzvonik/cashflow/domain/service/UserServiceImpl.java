package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.entity.mapper.AccountMapper;
import com.dzvonik.cashflow.domain.entity.mapper.TransactionMapper;
import com.dzvonik.cashflow.domain.entity.repository.AccountRepository;
import com.dzvonik.cashflow.domain.entity.repository.CategoryRepository;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional
    public List<TransactionDto> getAllTransactions(Long id) {

        User user = this.findById(id);
        List<Account> accounts = user.getAccounts();
        List<Category> categories = new java.util.ArrayList<>();

        for (Account a : accounts) {
            categories.addAll(a.getCategories());
        }

        List<Transaction> transactions = List.of();

        for (Category c : categories) {
            for (Transaction t : c.getTransactions()) {
                transactions.add(t);
            }
        }

        return transactions.stream().map(TransactionMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Account> getAllAccounts(Long id) {
        User user = findById(id);

        return user.getAccounts();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id=" + id + "not found"));
    }

}
