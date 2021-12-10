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
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int transactionId;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Transaction_Category",
            joinColumns = { @JoinColumn(name = "transaction_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    private List<Category> categories;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private LocalDate date;

    // Какое это отношение?
    private Integer sourceAccountId;

    // Какое это отношение?
    private Integer targetAccountId;

    private String payer;

    private String receiver;

    private String comment;

    public Transaction() {
        categories = new ArrayList<>();
    }
}
