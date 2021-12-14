package com.dzvonik.cashflow.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
