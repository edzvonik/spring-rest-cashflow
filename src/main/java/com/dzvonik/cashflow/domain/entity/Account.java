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
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int accountId;

    private String title;

    private String currency;

    public void setCurrency(Currency currency) {
        this.currency = currency.getCurrencyCode();
    }

    public Currency getCurrency() {
        return Currency.getInstance(currency);
    }

    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }
}
