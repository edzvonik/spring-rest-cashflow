package com.dzvonik.cashflow.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String userId;

    private String name;

    private String email;

    private String baseCurrency;

    public void setCurrency(Currency currency) {
        baseCurrency = currency.getCurrencyCode();
    }

    public Currency getCurrency() {
        return Currency.getInstance(baseCurrency);
    }

    private BigDecimal balance;

    @OneToMany(mappedBy = "user")
    private ArrayList<Account> accounts;

    @OneToMany(mappedBy = "user")
    private ArrayList<Category> categories;

    public User() {
        accounts = new ArrayList<>();
        categories = new ArrayList<>();
    }
}
