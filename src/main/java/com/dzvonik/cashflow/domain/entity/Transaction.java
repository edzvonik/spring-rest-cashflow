package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Entity
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private int id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Integer categoryId;

    private LocalDate date;

    private String comment;

}

