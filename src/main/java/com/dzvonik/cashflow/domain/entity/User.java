package com.dzvonik.cashflow.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String userId;

    private String name;

    private String email;

    @Enumerated
    private String baseCurrency;

    private BigDecimal balance;

    @OneToMany(mappedBy = "user")
    private ArrayList<Account> accounts;

    @OneToMany(mappedBy = "user")
    private ArrayList<Category> categories;
}
