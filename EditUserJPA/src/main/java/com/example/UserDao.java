package com.example;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Stateless
public class UserDao implements Serializable {

    @PersistenceContext(name = "MyPersistenceUnit")
    private EntityManager entityManager;

    public void save(User user) {
        System.out.println("UserDao.save");
        entityManager.persist(user);
    }

}