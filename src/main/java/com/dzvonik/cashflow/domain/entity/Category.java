package com.dzvonik.cashflow.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "title"})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @SequenceGenerator(name = "seq_category", sequenceName = "seq_category")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    private Long id;

    @Column(nullable = false)
    private String title;

    @JoinColumn(name = "category_id")
    @OneToMany
    private List<Transaction> transactions;

}

