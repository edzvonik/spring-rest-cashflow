package com.dzvonik.cashflow.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

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

