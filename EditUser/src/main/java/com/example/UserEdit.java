package com.example;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named // now it can be used in a JSF with EL
public class UserEdit implements Serializable {

    private User user = new User();

    @EJB
    private UserDao userDAO;

    public String save() {
        userDAO.save(this.user);
        System.out.println("UserEdit.save");
        return "index.jsp";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}