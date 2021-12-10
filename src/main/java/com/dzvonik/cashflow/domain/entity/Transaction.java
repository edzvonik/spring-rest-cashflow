package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private int transactionId;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Transaction_Category",
            joinColumns = { @JoinColumn(name = "transaction_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    @Getter
    private List<Category> categories;

    @Getter @Setter
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private TransactionType type;

    @Getter @Setter
    private LocalDate date;

    // Какое это отношение?
    @Getter @Setter
    private Integer sourceAccountId;

    // Какое это отношение?
    @Getter @Setter
    private Integer targetAccountId;

    @Getter @Setter
    private String payer;

    @Getter @Setter
    private String receiver;

    @Getter @Setter
    private String comment;

    public Transaction() {
        categories = new ArrayList<>();
    }
}
