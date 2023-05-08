package com.example.bankdemo.DataAccess;

import com.example.bankdemo.models.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<SavingsAccount,Long>,SavingsAccountRepository {
}
