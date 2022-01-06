package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

class TransactionTest {
    private Transaction defaultTransaction;
    private Transaction transactionWithData;

    @BeforeEach
    public void setUp() {
        defaultTransaction = new Transaction();

        LocalDate transactionDate = LocalDate.of(2022, 1, 6);

        transactionWithData = Transaction.builder()
                                .id(1)
                                .amount(new BigDecimal("0.01"))
                                .type(TransactionType.EXPENSE)
                                .date(transactionDate)
                                .comment("Test!")
                                .build();
    }

    @Test
    @DisplayName("Test default constructor")
    public void defaultConstructor_WhenObjectIsCreated_ThatAllFieldsNull() {
        assertThat(defaultTransaction.getId(), is(0));
        assertThat(defaultTransaction.getAmount(), nullValue());
        assertThat(defaultTransaction.getType(), nullValue());
        assertThat(defaultTransaction.getDate(), nullValue());
        assertThat(defaultTransaction.getComment(), nullValue());
    }

    @Test
    @DisplayName("Test builders")
    public void builders_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        assertThat(transactionWithData.getId(), is(1));
        assertThat(transactionWithData.getAmount(), is("0.01"));
        assertThat(transactionWithData.getType(), is(TransactionType.EXPENSE));
        assertThat(transactionWithData.getDate().get(ChronoField.MONTH_OF_YEAR), is("2022-01-06"));
        assertThat(transactionWithData.getComment(), is("Test!"));
    }

    @Test
    @DisplayName("Test toString()")
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdNameEmailValues() {
        assertThat(transactionWithData.toString(), is("Transaction(id=1, amount=0.01, type=EXPENSE, date=2022-01-06)"));
    }

    @Test
    @DisplayName("Test equals() and hashCode()")
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
