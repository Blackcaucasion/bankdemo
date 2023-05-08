package com.example.bankdemo.DataAccess;

import com.example.bankdemo.exceptions.AccountNotFountException;
import com.example.bankdemo.models.CurrentAccount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.Objects;

public class CurrentAccountRepositoryImpl implements CurrentAccountRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CurrentAccount findByAccNumber(Long accNumber) throws AccountNotFountException {
        CurrentAccount acc = null;
        try {
            String sql ="SELECT * FROM current WHERE acc_number =:acc_no";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("acc_no",accNumber );
            Object account = query.getSingleResult();

            //temporal fix while casting query.getSingleResult() to SavingsAccount account is not working!
            if(Objects.nonNull(account) ){
                double balnc = ((Double)((Object[])account)[1]).doubleValue();
                double overdraft = ((Double)((Object[])account)[2]).doubleValue();
                acc = new CurrentAccount( balnc,accNumber,overdraft);            }
        } catch (NoResultException e) {
                 e.printStackTrace();
                throw  new AccountNotFountException(" account no not found");

        }


        return acc;
    }
}

