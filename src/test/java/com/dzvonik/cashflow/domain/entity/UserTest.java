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

class UserTest {
    private User defaultUser;
    private User userWithData;

    @BeforeEach
    public void setUp() {
        defaultUser = new User();

        List<Account> testAccounts = new ArrayList();

        userWithData = User.builder()
                        .id(1)
                        .name("Test")
                        .email("test@email.com")
                        .baseCurrency("USD")
                        .accounts(testAccounts)
                        .build();
    }

    @Test
    @DisplayName("Test default constructor")
    public void defaultConstructor_WhenObjectIsCreated_ThatAllFieldsNull() {
        assertThat(defaultUser.getId(), is(0));
        assertThat(defaultUser.getName(), nullValue());
        assertThat(defaultUser.getEmail(), nullValue());
        assertThat(defaultUser.getBaseCurrency(), nullValue());
        assertThat(defaultUser.getAccounts(), nullValue());
    }

    @Test
    @DisplayName("Test builders")
    public void builders_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        assertThat(userWithData.getId(), is(1));
        assertThat(userWithData.getName(), is("Test"));
        assertThat(userWithData.getEmail(), is("test@email.com"));
        assertThat(userWithData.getBaseCurrency(), is("USD"));
        assertThat(userWithData.getAccounts(), notNullValue());
    }

    @Test
    @DisplayName("Test toString()")
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdNameEmailValues() {
        assertThat(userWithData.toString(), is("User(id=1, name=Test, email=test@email.com)"));
    }

    @Test
    @DisplayName("Test equals() and hashCode()")
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
