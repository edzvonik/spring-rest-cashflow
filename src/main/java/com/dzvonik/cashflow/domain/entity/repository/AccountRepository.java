package com.dzvonik.cashflow.domain.entity.repository;

import com.dzvonik.cashflow.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
