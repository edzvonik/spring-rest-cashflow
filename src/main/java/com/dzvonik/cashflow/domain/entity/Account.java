package com.dzvonik.cashflow.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", updatable = false, nullable = false)
    @Getter
    private int accountId;

    @Column(name = "title")
    @Getter @Setter
    private String title;

    @Column(name = "currency")
    private String currency;

    public void setCurrency(Currency currency) {
        this.currency = currency.getCurrencyCode();
    }

    public Currency getCurrency() {
        return Currency.getInstance(currency);
    }

    @Column(name = "balance")
    @Getter @Setter
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    @Getter
    private List<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }
}
