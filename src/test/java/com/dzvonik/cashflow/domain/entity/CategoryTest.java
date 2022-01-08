package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

class CategoryTest {
    private static Category categoryWithData;

    @BeforeAll
    public static void setUp() {
        List<Transaction> transactions = List.of();

        categoryWithData = Category.builder()
                .id(1)
                .title("Home")
                .transactions(transactions)
                .build();
    }

    @Test
    public void defaultConstructor_WhenObjectIsCreated_ThatNoThrownException() {
        try {
            Constructor constructor = Category.class.getDeclaredConstructor();
            Category category = (Category)constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            assertThat(e.getClass(), equalTo(ReflectiveOperationException.class));
        }
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        assertThat(categoryWithData.getId(), equalTo(1));
        assertThat(categoryWithData.getTitle(), equalTo("Home"));
        assertThat(categoryWithData.getTransactions(), equalTo(List.of()));
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdTitleValues() {
        assertThat(categoryWithData.toString(), equalTo("Category(id=1, title=Home)"));
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
