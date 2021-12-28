package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.CategoryType;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import lombok.Getter;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Entity
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORY")
    @SequenceGenerator(name = "SEQ_CATEGORY", sequenceName = "SEQ_CATEGORY", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}

