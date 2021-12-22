package com.dzvonik.cashflow.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Entity
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "SEQ_ACCOUNT", allocationSize = 100)
    private int id;

    @Column(nullable = false)
    private String title;

    private String currency;

    private BigDecimal balance;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}

