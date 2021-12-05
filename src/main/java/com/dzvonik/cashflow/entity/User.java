package com.dzvonik.cashflow.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class User {
    @Getter @Setter private String name;
    @Getter @Setter private String email;
    @Getter @Setter private String imagePath;
    @Getter @Setter private Currency baseCurrency;
    @Getter @Setter private BigDecimal balance;
    private ArrayList<Account> accounts;
    private ArrayList<Category> categories;

    public User() {
        accounts = new ArrayList<>();
        categories = new ArrayList<>();
    }
}
