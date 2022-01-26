package com.dzvonik.cashflow.domain.entity.repository;

import com.dzvonik.cashflow.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
