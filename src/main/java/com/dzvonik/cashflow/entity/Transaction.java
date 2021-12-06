package com.dzvonik.cashflow.entity;

import com.dzvonik.cashflow.entity.enums.TransactionTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @Column(name = "amount")
    @Getter @Setter
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    @Getter @Setter
    private TransactionTypes type;

    @Column(name = "date")
    @Getter @Setter
    private LocalDate date;

    // Какое это отношение?
    @Column(name = "source_account_id")
    @Getter @Setter
    private Integer sourceAccountId;

    // Какое это отношение?
    @Column(name = "target_account_id")
    @Getter @Setter
    private Integer targetAccountId;

    @Column(name = "payer")
    @Getter @Setter
    private String payer;

    @Column(name = "receiver")
    @Getter @Setter
    private String receiver;

    @Column(name = "comment")
    @Getter @Setter
    private String comment;

    public Transaction() {
        categories = new ArrayList<>();
    }
}
