package com.dzvonik.cashflow.domain.service;

import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.AccountInfoDto;
import com.dzvonik.cashflow.domain.entity.dto.CategoryInfoDto;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<TransactionDto> findAllTransactions(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found"));

        return user.getAccounts().stream()
                .map(account -> {
                    AccountInfoDto accountInfoDto = AccountInfoDto.builder()
                            .id(account.getId())
                            .title(account.getTitle())
                            .build();
                    return account.getCategories().stream()
                            .map(category -> {
                                CategoryInfoDto categoryInfoDto = CategoryInfoDto.builder()
                                        .id(category.getId())
                                        .title(category.getTitle())
                                        .build();
                                return category.getTransactions().stream()
                                        .map(transaction -> TransactionDto.builder()
                                                .id(transaction.getId())
                                                .amount(transaction.getAmount())
                                                .type(transaction.getType())
                                                .date(transaction.getDate())
                                                .comment(transaction.getComment())
                                                .accountInfo(accountInfoDto)
                                                .categoryInfo(categoryInfoDto)
                                                .build())
                                        .collect(Collectors.toList());
                            })
                            .flatMap(List::stream)
                            .collect(Collectors.toList());
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
