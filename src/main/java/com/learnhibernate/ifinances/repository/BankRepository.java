package com.learnhibernate.ifinances.repository;

import com.learnhibernate.ifinances.entities.Bank;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BankRepository {

    private final EntityManager entityManager;

    public BankRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Bank bank){
        entityManager.persist(bank);
    }

    public Bank findById(int id){
        return entityManager.find(Bank.class, id);
    }
}
