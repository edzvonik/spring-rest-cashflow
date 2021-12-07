package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.CategoryTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", updatable = false, nullable = false)
    @Getter
    private Integer categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Getter @Setter
    private User user;

    @ManyToMany(mappedBy = "categories")
    @Getter
    private List<Transaction> transactions;

    @Column(name = "title")
    @Getter @Setter
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type")
    @Getter @Setter
    private CategoryTypes type;

    public Category() {
        transactions = new ArrayList<>();
    }
}
