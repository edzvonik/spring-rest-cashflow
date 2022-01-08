package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

class AccountTest {
    private static Account accountWithData;

    @BeforeAll
    public static void setUp() {
        List<Category> categoryList = List.of();
        List<Transaction> transactionList = List.of();

        accountWithData = Account.builder()
                            .id(1)
                            .title("Cash")
                            .currency("USD")
                            .balance(new BigDecimal("0.01"))
                            .categories(categoryList)
                            .transactions(transactionList)
                            .build();
    }

    @Test
    public void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        try {
            Constructor constructor = Account.class.getDeclaredConstructor();
            Account account = (Account)constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            assertThat(e.getClass(), equalTo(ReflectiveOperationException.class));
        }
    }

    @Test
    public void builder_WhenValueSetViaBuilderMethod_ThatFieldShouldReturnThisValue() {
        assertThat(accountWithData.getId(), equalTo(1));
        assertThat(accountWithData.getTitle(),  equalTo("Cash"));
        assertThat(accountWithData.getCurrency(), equalTo("USD"));
        assertThat(accountWithData.getCategories(), equalTo(List.of()));
        assertThat(accountWithData.getTransactions(), equalTo(List.of()));
    }

    @Test
    public void toString_WhenCallToStringMethod_ThatReturnStringWithIdTitleCurrencyBalanceValues() {
        assertThat(accountWithData.toString(), equalTo("Account(id=1, title=Cash, currency=USD, balance=0.01)"));
    }

    @Test
    public void equalsAndHashCode() {
        EqualsVerifier.forClass(Account.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
