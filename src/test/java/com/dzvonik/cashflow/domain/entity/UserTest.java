package com.dzvonik.cashflow.domain.entity;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

class UserTest {
    @Test
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        try {
            Constructor constructor = User.class.getDeclaredConstructor();
            User user = (User)constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            assertThat(e.getClass(), equalTo(ReflectiveOperationException.class));
        }
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        User userWithData = User.builder()
                .id(1)
                .name("Test")
                .email("test@email.com")
                .baseCurrency("USD")
                .accounts(List.of())
                .build();

        assertThat(userWithData.getId(), equalTo(1));
        assertThat(userWithData.getName(), equalTo("Test"));
        assertThat(userWithData.getEmail(), equalTo("test@email.com"));
        assertThat(userWithData.getBaseCurrency(), equalTo("USD"));
        assertThat(userWithData.getAccounts(), equalTo(List.of()));
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdNameEmailValues() {
        User userWithData = User.builder()
                .id(1)
                .name("Test")
                .email("test@email.com")
                .baseCurrency("USD")
                .accounts(List.of())
                .build();

        assertThat(userWithData.toString(), equalTo("User(id=1, name=Test, email=test@email.com)"));
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
