package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;

import java.math.BigDecimal;
import java.time.LocalDate;

class TransactionTest {

    @Test
    void defaultConstructor_WhenObjectCreated_ThatNoExceptionThrown() {
        assertThatCode(() -> {
            Transaction transaction = Transaction.class.getDeclaredConstructor().newInstance();
        }).doesNotThrowAnyException();
    }

    @Test
    void builder_WhenSetValues_ThatReturnValues() {
        Transaction transactionWithData = Transaction.builder()
                .id(7)
                .amount(new BigDecimal("1023.56"))
                .type(TransactionType.EXPENSE)
                .date(LocalDate.of(2022, 1, 6))
                .comment("Test!")
                .build();

        assertThat(transactionWithData.getId()).isEqualTo(7);
        assertThat(transactionWithData.getAmount()).isEqualTo("1023.56");
        assertThat(transactionWithData.getType()).isEqualTo(TransactionType.EXPENSE);
        assertThat(transactionWithData.getDate()).isEqualTo("2022-01-06");
        assertThat(transactionWithData.getComment()).isEqualTo("Test!");
    }

    @Test
    void toString_WhenCallMethod_ThatReturnIdAmountTypeDateValues() {
        Transaction transactionWithData = Transaction.builder()
                .id(0)
                .amount(new BigDecimal("555963.12"))
                .type(TransactionType.INCOME)
                .date(LocalDate.of(2022, 12, 5))
                .build();

        assertThat(transactionWithData.toString()).contains(
            "id=0",
            "amount=555963.12",
            "type=INCOME",
            "date=2022-12-05"
        );
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.forClass(Transaction.class)
                .suppress(Warning.SURROGATE_KEY)
                .verify();
    }

}
