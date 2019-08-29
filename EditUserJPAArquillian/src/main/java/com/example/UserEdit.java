package com.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named // now it can be used in a JSF with EL
public class UserEdit implements Serializable {

    private User user = new User();

    @Inject private @FR IGreeter greeter;

    @Inject private UserDao userDAO;

    public String save() {
        userDAO.save(this.user);
        System.out.println("UserEdit.save");
        return "index.jsp";
    }

    public String getGreeting() {
        return greeter.greet("Bram");
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}