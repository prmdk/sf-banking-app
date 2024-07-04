package com.prmdk.bankapp.repo;

import com.prmdk.bankapp.entity.AccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountNumberRepo extends JpaRepository<AccountNumber, Integer> {
}
