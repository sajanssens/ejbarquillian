package com.example;

import com.example.cdi.FR;
import com.example.cdi.IGreeter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped // CDI bean; alternatively, use @ViewScoped, which is JSF specific, and not testable with plain Arquillian
@Named // now it can be used in a JSF-page using EL
public class UserEdit implements Serializable {

    private User user = new User();

    @Inject private @FR IGreeter greeter;

    // field injection
    @Inject
    private UserDao userDAO;

    // ctor injection
    // @Inject
    // public UserEdit(UserDao userDAO) { this.userDAO = userDAO; }

    // setter injection
    // @Inject
    // public void setUserDAO(UserDao userDAO) {
    //     this.userDAO = userDAO;
    // }

    public UserEdit() { }

    public String save() {
        userDAO.save(this.user);
        System.out.println("UserEdit.save");
        return "index.jsp";
    }

    public String getGreeting() { return greeter.greet("Bram"); }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UserDao getUserDAO() { return userDAO; }
}