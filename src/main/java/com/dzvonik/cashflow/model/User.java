package com.dzvonik.cashflow.model;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Currency;

public class User {
    private String name;
    private String email;
    private String imagePath;
    private Currency baseCurrency;
    private BigDecimal balance;
    private ArrayList<Account> accounts;
    private ArrayList<Category> categories;

    // Work with balance
    private void calcBalance() {

    }

    // Work with accounts
    public Account getAccount(int accountId) {}
    public ArrayList<Account> getAccounts() {}
    public void addAccount(Account newAccount) {}
    public void removeAccount(int accountId) {}
    public void editAccount(int accountId, Account newAccount) {}

    // Work with categories
    public Category getCategory(int categoryId) {}
    public ArrayList<Category> getCategories() {}
    public void addCategory(Category newCategory) {}
    public void removeCategory(int categoryId) {}
    public void editCategory(int categoryId, Category newCategory) {}

}
