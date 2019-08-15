package com.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named
public class UserEdit implements Serializable {

    private User user = new User();

    @Inject
    UserDao userDAO;

    public String save() {
        userDAO.save(this.user);
        // addFlashMessage("com.example.User " + this.user.getId() + " saved");
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