package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.CategoryType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(mappedBy = "categories")
    private List<Transaction> transactions;

    private String title;

    @Enumerated(EnumType.STRING)
    private CategoryType type;
}
