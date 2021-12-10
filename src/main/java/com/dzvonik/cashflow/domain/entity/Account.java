package com.dzvonik.cashflow.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private int accountId;

    @Getter @Setter
    private String title;

    private String currency;

    public void setCurrency(Currency currency) {
        this.currency = currency.getCurrencyCode();
    }

    public Currency getCurrency() {
        return Currency.getInstance(currency);
    }

    @Getter @Setter
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    @Getter
    private List<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }
}
