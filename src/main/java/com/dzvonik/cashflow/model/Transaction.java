package com.dzvonik.cashflow.model;

import java.util.Date;

public class Transaction {
    int transactionId;
    TransactionTypes type;
    Date date;
    int sourceAccount;
    int targetAccount;
    String comment;

    // Типы транзакций
    public enum TransactionTypes {
        INCOME,
        EXPENSE,
        TRANSFER
    }
}
