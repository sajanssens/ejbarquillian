package com.example;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UserDao implements Serializable {

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager em;

    public void save(User user) {
        System.out.println("UserDao.save");
        findAll().forEach(System.out::println);
        em.persist(user);
    }

    public List<User> findAll() {
        return em.createNamedQuery("User.getAll", User.class).getResultList();
    }

}