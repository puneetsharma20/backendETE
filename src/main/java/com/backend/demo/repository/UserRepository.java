package com.backend.demo.repository;


import com.backend.demo.model.UserDetail;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "Backendtest")
    private EntityManagerFactory entityManagerFactory;

    public boolean register(UserDetail newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        }
    }
    public UserDetail checkCredentials(String username) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            //TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
            TypedQuery<UserDetail> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", UserDetail.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}