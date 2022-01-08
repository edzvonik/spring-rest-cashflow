package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

class CategoryTest {
    @Test
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        try {
            Constructor constructor = Category.class.getDeclaredConstructor();
            Category category = (Category)constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            assertThat(e.getClass(), equalTo(ReflectiveOperationException.class));
        }
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        Category categoryWithData = Category.builder()
                .id(1)
                .title("Home")
                .transactions(List.of())
                .build();

        assertThat(categoryWithData.getId(), equalTo(1));
        assertThat(categoryWithData.getTitle(), equalTo("Home"));
        assertThat(categoryWithData.getTransactions(), equalTo(List.of()));
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdTitleValues() {
        Category categoryWithData = Category.builder()
                .id(1)
                .title("Home")
                .transactions(List.of())
                .build();

        assertThat(categoryWithData.toString(), equalTo("Category(id=1, title=Home)"));
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
