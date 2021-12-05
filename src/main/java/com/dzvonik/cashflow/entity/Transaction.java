package com.dzvonik.cashflow.entity;

import com.dzvonik.cashflow.entity.enums.TransactionTypes;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction  {
    @Getter @Setter int transactionId;
    @Getter @Setter BigDecimal amount;
    @Getter @Setter TransactionTypes type;
    @Getter @Setter int categoryId;
    @Getter @Setter Date date;
    @Getter @Setter int sourceAccountId;
    @Getter @Setter int targetAccountId;
    @Getter @Setter String contractor;
    @Getter @Setter String comment;
}
