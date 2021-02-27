package com.learnhibernate.ifinances.repository;

import com.learnhibernate.ifinances.entities.Credential;
import com.learnhibernate.ifinances.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CredentialRepository {

    private final EntityManager entityManager;

    public CredentialRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Credential credential){
        entityManager.persist(credential);
    }

    public List<Credential> findByUserName(String userName){
        TypedQuery<Credential> namedQuery = entityManager.createNamedQuery("find_by_userName", Credential.class);
        namedQuery.setParameter("userName", userName);
        return namedQuery.getResultList();
    }
}
