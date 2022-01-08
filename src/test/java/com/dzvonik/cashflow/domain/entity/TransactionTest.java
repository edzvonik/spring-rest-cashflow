package com.dzvonik.cashflow.domain.entity;

import com.dzvonik.cashflow.domain.entity.enums.TransactionType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;

import java.math.BigDecimal;
import java.time.LocalDate;

class TransactionTest {
    private static Transaction transactionWithData;

    @BeforeAll
    public static void setUp() {

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
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        try {
            Constructor[] constructors = Transaction.class.getDeclaredConstructors();
            Transaction transaction = (Transaction) constructors[0].newInstance();
        } catch (ReflectiveOperationException e) {
            assertThat(e.getClass(), equalTo(ReflectiveOperationException.class));
        }
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        assertThat(transactionWithData.getId(), equalTo(1));
        assertThat(transactionWithData.getAmount().toString(), equalTo("0.01"));
        assertThat(transactionWithData.getType(), equalTo(TransactionType.EXPENSE));
        assertThat(transactionWithData.getDate().toString(), equalTo("2022-01-06"));
        assertThat(transactionWithData.getComment(), equalTo("Test!"));
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdNameEmailValues() {
        assertThat(transactionWithData.toString(), equalTo("Transaction(id=1, amount=0.01, type=EXPENSE, date=2022-01-06)"));
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(Transaction.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
