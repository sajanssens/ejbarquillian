package com.example;

import javax.ejb.Stateful;
import java.io.Serializable;

@Stateful
public class UserDao implements Serializable {

    public void save(User user) {
        System.out.println("UserDao.save");
    }

}