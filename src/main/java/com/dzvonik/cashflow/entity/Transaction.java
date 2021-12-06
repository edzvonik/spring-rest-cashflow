package com.dzvonik.cashflow.entity;

import com.dzvonik.cashflow.entity.enums.TransactionTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    @Getter @Setter
    int transactionId;

    @Column(name = "amount")
    @Getter @Setter
    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    @Getter @Setter
    TransactionTypes type;

    @OneToMany
    @Column(name = "category_id")
    @Getter @Setter
    List<Integer> categoriesId;

    @Column(name = "date")
    @Getter @Setter
    LocalDate date;

    @Column(name = "source_account_id")
    @Getter @Setter
    int sourceAccountId;

    @Column(name = "target_account_id")
    @Getter @Setter
    int targetAccountId;

    @Column(name = "contractor")
    @Getter @Setter
    String contractor;

    @Column(name = "comment")
    @Getter @Setter
    String comment;
}
