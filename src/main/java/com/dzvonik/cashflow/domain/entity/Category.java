package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.CategoryType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private Integer categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Getter @Setter
    private User user;

    @ManyToMany(mappedBy = "categories")
    @Getter
    private List<Transaction> transactions;

    @Getter @Setter
    private String title;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private CategoryType type;

    public Category() {
        transactions = new ArrayList<>();
    }
}
