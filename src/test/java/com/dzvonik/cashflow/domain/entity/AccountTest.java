package com.dzvonik.cashflow.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.mockito.Mockito;

import java.lang.reflect.Constructor;

import java.math.BigDecimal;
import java.util.List;

class AccountTest {

    @Test
    void defaultConstructor_WhenObjectCreated_ThatNoThrownException() {
        assertThatCode(() -> {
            Constructor constructor = Account.class.getDeclaredConstructor();
            Account account = (Account)constructor.newInstance();
        }).doesNotThrowAnyException();
    }

    private List<Transaction> getTransactions() {
        Transaction transaction1 = Mockito.mock(Transaction.class);
        Transaction transaction2 = Mockito.mock(Transaction.class);

        return List.of(transaction1, transaction2);
    }

    private List<Category> getCategories() {
        Category category1 = Mockito.mock(Category.class);
        Category category2 = Mockito.mock(Category.class);

        return List.of(category1, category2);
    }

    @Test
    void builder_WhenSetValues_ThatReturnValues() {
        List<Transaction> transactions = getTransactions();
        List<Category> categories = getCategories();

        Account accountWithData = Account.builder()
                .id(5)
                .title("Cash")
                .currency("USD")
                .balance(new BigDecimal("0.01"))
                .categories(categories)
                .transactions(transactions)
                .build();

        assertThat(accountWithData.getId()).isEqualTo(5);
        assertThat(accountWithData.getTitle()).isEqualTo("Cash");
        assertThat(accountWithData.getCurrency()).isEqualTo("USD");
        assertThat(accountWithData.getBalance()).isEqualTo("0.01");
        assertThat(accountWithData.getCategories()).containsExactlyInAnyOrderElementsOf(categories);
        assertThat(accountWithData.getTransactions()).containsExactlyInAnyOrderElementsOf(transactions);
    }

    @Test
    void toString_WhenCallMethod_ThatReturnIdTitleCurrencyBalanceValues() {
        Account accountWithData = Account.builder()
                .id(0)
                .title("Card")
                .currency("RUB")
                .balance(new BigDecimal("0.00"))
                .build();

        assertThat(accountWithData.toString()).isEqualTo("Account(id=0, title=Card, currency=RUB, balance=0.00)");
    }

    @Test
    void equalsAndHashCode() {
        EqualsVerifier.forClass(Account.class).suppress(Warning.SURROGATE_KEY).verify();
    }

}
