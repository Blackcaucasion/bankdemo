package com.example.bankdemo.DataAccess;

import com.example.bankdemo.models.CurrentAccTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccTransactionsRepository extends JpaRepository<CurrentAccTransactions,Long> {
}
