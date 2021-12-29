package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transaction")
    @SequenceGenerator(name = "seq_transaction", sequenceName = "seq_transaction", allocationSize = 1)
    private int id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Integer categoryId;

    @Column(nullable = false)
    private LocalDate date;

    private String comment;

}

