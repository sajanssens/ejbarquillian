package com.example;

import javax.ejb.Stateless;

@Stateless
public class UserDao {

    public void save(User user) {
        System.out.println("UserDao.save");
    }

}