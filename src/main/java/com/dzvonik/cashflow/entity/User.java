package com.dzvonik.cashflow.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, nullable = false)
    @Getter
    private String userId;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "image_path")
    @Getter @Setter
    private String imagePath;

    @Column(name = "base_currency")
    private String baseCurrency;

    public void setCurrency(Currency currency) {
        baseCurrency = currency.getCurrencyCode();
    }

    public Currency getCurrency() {
        return Currency.getInstance(baseCurrency);
    }

    @Column(name = "balance")
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
