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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class AccountTest {
    private Account defaultAccount;
    private Account accountWithData;

    @BeforeEach
    public void setUp() {
        defaultAccount = new Account();

        List<Category> categories = new ArrayList();
        List<Transaction> transactions = new ArrayList();

        accountWithData = Account.builder()
                            .id(1)
                            .title("Cash")
                            .currency("USD")
                            .balance(new BigDecimal("0.01"))
                            .categories(categories)
                            .transactions(transactions)
                            .build();
    }

    @Test
    @DisplayName("Test default constructor")
    public void defaultConstructor_WhenObjectIsCreated_ThatAllFieldsNull() {
        assertThat(defaultAccount.getId(), is(0));
        assertThat(defaultAccount.getTitle(), nullValue());
        assertThat(defaultAccount.getCurrency(), nullValue());
        assertThat(defaultAccount.getCategories(), nullValue());
        assertThat(defaultAccount.getTransactions(), nullValue());
    }

    @Test
    @DisplayName("Test builders")
    public void builders_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        assertThat(accountWithData.getId(), is(1));
        assertThat(accountWithData.getTitle(), is("Cash"));
        assertThat(accountWithData.getCurrency(), is("USD"));
        assertThat(accountWithData.getCategories(), notNullValue());
        assertThat(accountWithData.getTransactions(), notNullValue());
    }

    @Test
    @DisplayName("Test toString()")
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdNameEmailValues() {
        assertThat(accountWithData.toString(), is("Account(id=1, title=Cash, currency=USD, balance=0.01)"));
    }

    @Test
    @DisplayName("Test equals() and hashCode()")
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(User.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
