package com.dzvonik.cashflow.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private String userId;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    private String baseCurrency;

    public void setCurrency(Currency currency) {
        baseCurrency = currency.getCurrencyCode();
    }

    public Currency getCurrency() {
        return Currency.getInstance(baseCurrency);
    }

    @Getter @Setter
    private BigDecimal balance;

    @OneToMany(mappedBy = "user")
    @Getter
    private ArrayList<Account> accounts;

    @OneToMany(mappedBy = "user")
    @Getter
    private ArrayList<Category> categories;

    public User() {
        accounts = new ArrayList<>();
        categories = new ArrayList<>();
    }
}
