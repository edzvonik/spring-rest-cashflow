package com.dzvonik.cashflow.domain.entity.repository;

import com.dzvonik.cashflow.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}

