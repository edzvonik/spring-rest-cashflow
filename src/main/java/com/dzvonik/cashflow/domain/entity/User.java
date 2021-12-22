package com.dzvonik.cashflow.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "SEQ_USER", allocationSize = 50)
    private String id;

    private String name;

    private String email;

    private String baseCurrency;

    private BigDecimal balance;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Account> accounts;

}

