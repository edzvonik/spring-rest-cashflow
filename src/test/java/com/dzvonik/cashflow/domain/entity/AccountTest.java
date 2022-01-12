package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.math.BigDecimal;
import java.util.List;

class AccountTest {

    @Test
    void defaultConstructor_WhenCreatedWithReflection_ThanNoExceptionThrown() {
        assertThatCode(() -> Account.class.getDeclaredConstructor().newInstance())
                .doesNotThrowAnyException();
    }

    @Test
    void builder_WhenSetValues_ThanReturnValues() {
        List<Transaction> transactions = mock(Transaction.class);
        List<Category> categories = mock(Category.class);

        Account accountWithData = Account.builder()
                .id(5)
                .title("Cash")
                .currency("USD")
                .balance(new BigDecimal("0.01"))
                .categories(categories)
                .transactions(transactions)
                .build();

        assertThat(accountWithData.getId()).isEqualTo(5);
        assertThat(accountWithData.getTitle()).isEqualTo("Cash");
        assertThat(accountWithData.getCurrency()).isEqualTo("USD");
        assertThat(accountWithData.getBalance()).isEqualTo(new BigDecimal("0.01"));
        assertThat(accountWithData.getCategories()).containsExactlyInAnyOrderElementsOf(categories);
        assertThat(accountWithData.getTransactions()).containsExactlyInAnyOrderElementsOf(transactions);
    }

    @Test
    void toString_WhenCall_ThanReturnStringRepresentation() {
        Account accountWithData = Account.builder()
                .id(0)
                .title("Card")
                .currency("RUB")
                .balance(new BigDecimal("0.00"))
                .build();

        assertThat(accountWithData.toString()).contains(
            "id=0",
            "title=Card",
            "currency=RUB",
            "balance=0.00"
        );
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.forClass(Account.class)
                .suppress(Warning.SURROGATE_KEY)
                .verify();
    }

    private <T> List<T> mock(Class<T> c) {
        return List.of(org.mockito.Mockito.mock(c));
    }

}
