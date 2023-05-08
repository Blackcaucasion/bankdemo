package com.example.bankdemo.DataAccess;

import com.example.bankdemo.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccTransactionsRepository  extends JpaRepository<Transactions,Long> {
}
