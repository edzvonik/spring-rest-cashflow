package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.util.ArrayList;
import java.util.List;

class CategoryTest {
    private Category defaultCategory;
    private Category categoryWithData;

    @BeforeEach
    public void setUp() {
        defaultCategory = new Category();

        List<Transaction> transactions = new ArrayList();

        categoryWithData = Category.builder()
                .id(1)
                .title("Home")
                .transactions(transactions)
                .build();
    }

    @Test
    @DisplayName("Test default constructor")
    public void defaultConstructor_WhenObjectIsCreated_ThatAllFieldsNull() {
        assertThat(defaultCategory.getId(), is(0));
        assertThat(defaultCategory.getTitle(), nullValue());
        assertThat(defaultCategory.getTransactions(), nullValue());
    }

    @Test
    @DisplayName("Test builders")
    public void builders_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        assertThat(categoryWithData.getId(), is(1));
        assertThat(categoryWithData.getTitle(), is("Home"));
        assertThat(categoryWithData.getTransactions(), notNullValue());
    }

    @Test
    @DisplayName("Test toString()")
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdNameEmailValues() {
        assertThat(categoryWithData.toString(), is("Category(id=1, title=Home)"));
    }

    @Test
    @DisplayName("Test equals() and hashCode()")
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
