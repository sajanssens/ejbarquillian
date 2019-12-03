package com.example;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UserDao implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        System.out.println("UserDao.save");
        findAll().forEach(System.out::println);
        em.persist(user);
    }

    public List<User> findAll() {
        return em.createNamedQuery("User.getAll", User.class).getResultList();
    }

    public void delete(User u) {
        User user = em.find(User.class, u.getId());
        em.remove(user);
    }

}