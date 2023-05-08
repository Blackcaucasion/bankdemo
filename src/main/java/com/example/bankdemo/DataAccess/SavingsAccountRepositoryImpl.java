package com.example.bankdemo.DataAccess;

import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.models.SavingsAccount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.Objects;

public class SavingsAccountRepositoryImpl implements SavingsAccountRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public SavingsAccount findByAccNumber(Long accNumber)  throws AccountNotFountException {
        SavingsAccount acc =null;
        try{
            String sql ="SELECT * FROM savings WHERE acc_number =:acc_no";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("acc_no",accNumber );
            Object account = query.getSingleResult();
            if ((Objects.nonNull(account))){
                {
                    double balnc = ((Double)((Object[])account)[1]).doubleValue();
                    boolean isOpen= ((Boolean)((Object[])account)[2]).booleanValue();
                    acc = new SavingsAccount( balnc,accNumber,isOpen);
                }            }

        } catch (Exception e) {
            e.printStackTrace();
            throw  new AccountNotFountException(" account no not found");
        }

        return acc;

    }
}
