package com.example.bankdemo.DataAccess;

import com.example.bankdemo.models.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentRepository extends JpaRepository<CurrentAccount,Long>,CurrentAccountRepository {
}
