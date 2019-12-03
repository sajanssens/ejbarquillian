package com.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped // CDI bean; alternatively, use @ViewScoped, which is JSF specific, and not testable with plain Arquillian
@Named // now it can be used in a JSF-page using EL
public class UserEdit implements Serializable {

    private User user = new User();

    @Inject
    private UserDao userDAO;

    public UserEdit() { }

    public String save() {
        userDAO.save(this.user);
        return "index.jsp";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getGreeting() { return "Hello Bram!"; }
}