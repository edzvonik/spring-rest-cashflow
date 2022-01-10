package com.dzvonik.cashflow.domain.entity;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;

import java.util.List;

class UserTest {

    @Test
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        assertThatCode(() -> {
            Constructor constructor = User.class.getDeclaredConstructor();
            User user = (User)constructor.newInstance();
        }).doesNotThrowAnyException();
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        User userWithData = User.builder()
                .id(1)
                .name("Test1")
                .email("test@email.com")
                .baseCurrency("USD")
                .accounts(List.of())
                .build();

        assertThat(userWithData.getId()).isEqualTo(1);
        assertThat(userWithData.getName()).isEqualTo("Test1");
        assertThat(userWithData.getEmail()).isEqualTo("test@email.com");
        assertThat(userWithData.getBaseCurrency()).isEqualTo("USD");
        assertThat(userWithData.getAccounts()).isEqualTo(List.of());
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdNameEmailValues() {
        User userWithData = User.builder()
                .id(1)
                .name("Test2")
                .email("test@email.com")
                .baseCurrency("RUB")
                .accounts(List.of())
                .build();

        assertThat(userWithData.toString()).isEqualTo("User(id=1, name=Test2, email=test@email.com)");
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
