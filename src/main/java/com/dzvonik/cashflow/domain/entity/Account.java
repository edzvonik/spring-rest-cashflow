package com.dzvonik.cashflow.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String title;

    private String currency;

    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
