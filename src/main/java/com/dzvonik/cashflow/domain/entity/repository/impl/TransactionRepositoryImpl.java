package com.dzvonik.cashflow.domain.entity.repository.impl;

import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.repository.TransactionRepositoryCustom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<Transaction> findAllByLastThreeMonthAndUser(User user) {
        Query query = em.createNativeQuery("SELECT * FROM Transaction t "
                     +"WHERE t.date >= ?1 AND t.account_id "
                     +"IN (SELECT id FROM Account a WHERE a.user_id = ?2)"
                     +"ORDER BY date DESC", Transaction.class);

        LocalDate now = LocalDate.of(2022, 06, 01);
        LocalDate threeMonthAgo = now.minusMonths(3);

        query.setParameter(1, threeMonthAgo);
        query.setParameter(2, user.getId());

        return query.getResultList();
    }

}
