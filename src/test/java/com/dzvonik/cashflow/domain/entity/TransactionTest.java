package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDate;

class TransactionTest {
    @Test
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        try {
            Constructor constructor = Transaction.class.getDeclaredConstructor();
            Transaction transaction = (Transaction)constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            assertThat(e.getClass(), equalTo(ReflectiveOperationException.class));
        }
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        Transaction transactionWithData = Transaction.builder()
                .id(1)
                .amount(new BigDecimal("0.01"))
                .type(TransactionType.EXPENSE)
                .date(LocalDate.of(2022, 1, 6))
                .comment("Test!")
                .build();

        assertThat(transactionWithData.getId(), equalTo(1));
        assertThat(transactionWithData.getAmount().toString(), equalTo("0.01"));
        assertThat(transactionWithData.getType(), equalTo(TransactionType.EXPENSE));
        assertThat(transactionWithData.getDate().toString(), equalTo("2022-01-06"));
        assertThat(transactionWithData.getComment(), equalTo("Test!"));
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdAmountTypeDateValues() {
        Transaction transactionWithData = Transaction.builder()
                .id(1)
                .amount(new BigDecimal("0.01"))
                .type(TransactionType.EXPENSE)
                .date(LocalDate.of(2022, 1, 6))
                .comment("Test!")
                .build();

        assertThat(transactionWithData.toString(), equalTo("Transaction(id=1, amount=0.01, type=EXPENSE, date=2022-01-06)"));
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(Transaction.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
