package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;
import java.util.List;

class CategoryTest {

    @Test
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        assertThatCode(() -> {
            Constructor constructor = Category.class.getDeclaredConstructor();
            Category category = (Category)constructor.newInstance();
        }).doesNotThrowAnyException();
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        Category categoryWithData = Category.builder()
                .id(3)
                .title("Home")
                .transactions(List.of())
                .build();

        assertThat(categoryWithData.getId()).isEqualTo(3);
        assertThat(categoryWithData.getTitle()).isEqualTo("Home");
        assertThat(categoryWithData.getTransactions()).isEqualTo(List.of());
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdTitleValues() {
        Category categoryWithData = Category.builder()
                .id(0)
                .title("Home")
                .transactions(List.of())
                .build();

        assertThat(categoryWithData.toString()).isEqualTo("Category(id=0, title=Home)");
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
