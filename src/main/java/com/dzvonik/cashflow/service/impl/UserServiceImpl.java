package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository;
import com.dzvonik.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found"));
    }

}
