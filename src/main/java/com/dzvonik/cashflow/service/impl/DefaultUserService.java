package com.dzvonik.cashflow.service.impl;

import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.repository.UserRepository;
import com.dzvonik.cashflow.exception.ResourceNotFoundException;
import com.dzvonik.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " - not found"));
    }

}
