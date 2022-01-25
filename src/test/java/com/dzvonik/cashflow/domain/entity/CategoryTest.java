package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.util.List;

class CategoryTest {

    @Test
    void defaultConstructor_WhenCreatedWithReflection_ThanNoExceptionThrown() {
        assertThatCode(() -> Category.class.getDeclaredConstructor().newInstance())
                .doesNotThrowAnyException();
    }

    @Test
    void constructor_WhenSetValues_ThanReturnValues() {
        List<Transaction> transactions = mock();
        Category categoryWithData = new Category(3L, "Home", transactions);

        assertThat(categoryWithData.getId()).isEqualTo(3L);
        assertThat(categoryWithData.getTitle()).isEqualTo("Home");
        assertThat(categoryWithData.getTransactions()).containsExactlyInAnyOrderElementsOf(transactions);
    }

    @Test
    void toString_WhenCall_ThanReturnStringRepresentation() {
        Category categoryWithData = new Category(0L, "Home", mock());

        assertThat(categoryWithData.toString()).contains(
            "id=0",
            "title=Home"
        );
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class)
                .suppress(Warning.SURROGATE_KEY)
                .verify();
    }

    private List<Transaction> mock() {
        return List.of(org.mockito.Mockito.mock(Transaction.class));
    }

}
