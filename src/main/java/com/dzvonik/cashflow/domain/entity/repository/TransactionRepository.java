package com.dzvonik.cashflow.domain.entity.repository;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    default List<Transaction> findAllByAccountInAndDateAfterOrderByDateDesc(List<Account> accounts, LocalDate date) {
        return findAllByAccountInAndDateBetween(accounts, date.minusMonths(3), date);
    }

    List<Transaction> findAllByAccountInAndDateBetween(List<Account> account, LocalDate dateStart, LocalDate dateEnd);

}
