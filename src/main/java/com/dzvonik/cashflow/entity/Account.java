package com.dzvonik.cashflow.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Account {
    @Getter @Setter int accountId;
    @Getter @Setter String title;
    @Getter @Setter Currency currency;
    @Getter @Setter BigDecimal balance;
    List<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }
}
