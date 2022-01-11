package com.dzvonik.cashflow.domain.entity;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.mockito.Mockito;

import java.util.List;

class UserTest {

    @Test
    void defaultConstructor_WhenObjectCreated_ThatNoExceptionThrown() {
        assertThatCode(() -> {
            User user = User.class.getDeclaredConstructor().newInstance();
        }).doesNotThrowAnyException();
    }

    @Test
    void builder_WhenSetValues_ThatReturnValues() {
        List<Account> accounts = mockAccounts();

        User userWithData = User.builder()
                .id(1)
                .name("Test1")
                .email("test@email.com")
                .baseCurrency("USD")
                .accounts(accounts)
                .build();

        assertThat(userWithData.getId()).isEqualTo(1);
        assertThat(userWithData.getName()).isEqualTo("Test1");
        assertThat(userWithData.getEmail()).isEqualTo("test@email.com");
        assertThat(userWithData.getBaseCurrency()).isEqualTo("USD");
        assertThat(userWithData.getAccounts()).containsExactlyInAnyOrderElementsOf(accounts);
    }

    @Test
    void toString_WhenCallMethod_ThatReturnIdNameEmailValues() {
        User userWithData = User.builder()
                .id(0)
                .name("Test2")
                .email("test@email.com")
                .baseCurrency("RUB")
                .build();

        assertThat(userWithData.toString()).isEqualTo("User(id=0, name=Test2, email=test@email.com)");
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class)
                .suppress(Warning.SURROGATE_KEY)
                .verify();
    }

    private List<Account> mockAccounts() {
        Account account1 = Mockito.mock(Account.class);
        Account account2 = Mockito.mock(Account.class);

        return List.of(account1, account2);
    }

}
