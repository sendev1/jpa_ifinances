package com.learnhibernate.ifinances.repository;

import com.learnhibernate.ifinances.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository {

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user){
        entityManager.persist(user);
    }

    public User findById(int id){
        return entityManager.find(User.class,id);
    }
}
