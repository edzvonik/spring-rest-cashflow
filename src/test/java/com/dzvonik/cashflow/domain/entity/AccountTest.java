package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;

import java.math.BigDecimal;
import java.util.List;

class AccountTest {

    @Test
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        assertThatCode(() -> {
            Constructor constructor = Account.class.getDeclaredConstructor();
            Account account = (Account)constructor.newInstance();
        }).doesNotThrowAnyException();
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        Account accountWithData = Account.builder()
                .id(5)
                .title("Cash")
                .currency("USD")
                .balance(new BigDecimal("0.01"))
                .categories(List.of())
                .transactions(List.of())
                .build();

        assertThat(accountWithData.getId()).isEqualTo(5);
        assertThat(accountWithData.getTitle()).isEqualTo("Cash");
        assertThat(accountWithData.getCurrency()).isEqualTo("USD");
        assertThat(accountWithData.getBalance()).isEqualTo("0.01");
        assertThat(accountWithData.getCategories()).isEqualTo(List.of());
        assertThat(accountWithData.getTransactions()).isEqualTo(List.of());
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdTitleCurrencyBalanceValues() {
        Account accountWithData = Account.builder()
                .id(0)
                .title("Card")
                .currency("RUB")
                .balance(new BigDecimal("0.00"))
                .categories(List.of())
                .transactions(List.of())
                .build();

        assertThat(accountWithData.toString()).isEqualTo("Account(id=0, title=Card, currency=RUB, balance=0.00)");
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(Account.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
