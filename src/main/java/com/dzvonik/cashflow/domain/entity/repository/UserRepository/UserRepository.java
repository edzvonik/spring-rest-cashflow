package com.dzvonik.cashflow.domain.entity.repository.UserRepository;

import com.dzvonik.cashflow.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
