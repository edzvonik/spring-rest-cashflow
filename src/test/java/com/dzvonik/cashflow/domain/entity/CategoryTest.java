package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.mockito.Mockito;

import java.util.List;

class CategoryTest {

    @Test
    void defaultConstructor_WhenObjectCreated_ThatNoExceptionThrown() {
        assertThatCode(() -> {
            Category category = Category.class.getDeclaredConstructor().newInstance();
        }).doesNotThrowAnyException();
    }

    @Test
    void builder_WhenSetValues_ThatReturnValues() {
        List<Transaction> transactions = mockTransactions();

        Category categoryWithData = Category.builder()
                .id(3)
                .title("Home")
                .transactions(transactions)
                .build();

        assertThat(categoryWithData.getId()).isEqualTo(3);
        assertThat(categoryWithData.getTitle()).isEqualTo("Home");
        assertThat(categoryWithData.getTransactions()).containsExactlyInAnyOrderElementsOf(transactions);
    }

    @Test
    void toString_WhenCallMethod_ThatReturnIdTitleValues() {
        Category categoryWithData = Category.builder()
                .id(0)
                .title("Home")
                .build();

        assertThat(categoryWithData.toString()).isEqualTo("Category(id=0, title=Home)");
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class)
                .suppress(Warning.SURROGATE_KEY)
                .verify();
    }

    private List<Transaction> mockTransactions() {
        Transaction transaction1 = Mockito.mock(Transaction.class);
        Transaction transaction2 = Mockito.mock(Transaction.class);

        return List.of(transaction1, transaction2);
    }

}
