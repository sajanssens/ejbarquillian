package com.example;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.io.Serializable;

@Stateless
@Named
public class UserDao implements Serializable {

    // @PersistenceContext
    // private EntityManager entityManager;

    public void save(User user) {
        System.out.println("UserDao.save");
        // entityManager.persist(user);
    }

    // public void update(com.example.User user) {
    //     entityManager.merge(user);
    // }

    // public List<com.example.User> getAll() {
    //     return entityManager.createNamedQuery("com.example.User.getAll", com.example.User.class)
    //             .getResultList();
    // }

}