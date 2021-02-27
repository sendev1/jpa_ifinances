package com.learnhibernate.ifinances.repository;

import com.learnhibernate.ifinances.entities.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AccountRepository {

    private final EntityManager entityManager;

    public AccountRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Account account){
        entityManager.persist(account);
    }

    public Account findById(int id){
        return entityManager.find(Account.class, id);
    }
}
