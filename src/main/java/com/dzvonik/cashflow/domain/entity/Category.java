package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.CategoryType;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Integer id;

    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    @Enumerated(EnumType.STRING)
    private CategoryType type;

}

