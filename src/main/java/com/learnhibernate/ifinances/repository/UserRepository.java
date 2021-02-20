package com.learnhibernate.ifinances.repository;

import com.learnhibernate.ifinances.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepository {

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User user){
        entityManager.persist(user);
    }

    /*public List<Student> findByName(String name){
        TypedQuery<Student> namedQuery = entityManager.createNamedQuery("find_stud_by-name", Student.class);
        namedQuery.setParameter("name", name);
        return namedQuery.getResultList();
    }*/
}
