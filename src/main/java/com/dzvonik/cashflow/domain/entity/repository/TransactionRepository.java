package com.dzvonik.cashflow.domain.entity.repository;

import com.dzvonik.cashflow.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
