package com.dzvonik.cashflow.domain.entity.dto;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto {

    private Long id;

    private BigDecimal amount;

    private TransactionType type;

    private LocalDate date;

    private String comment;

}

