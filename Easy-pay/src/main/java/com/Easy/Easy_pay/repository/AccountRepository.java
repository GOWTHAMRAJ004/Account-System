package com.Easy.Easy_pay.repository;

import com.Easy.Easy_pay.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
