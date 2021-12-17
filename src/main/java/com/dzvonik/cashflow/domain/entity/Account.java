package com.dzvonik.cashflow.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Entity
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private int id;

    private String title;

    private String currency;

    private BigDecimal balance;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}

