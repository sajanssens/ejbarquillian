package com.example;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.transaction.*;
import java.io.Serializable;

@ViewScoped
@Named // now it can be used in a JSF with EL
public class UserEdit implements Serializable {

    private User user = new User();

    @Inject
    private UserDao userDAO;

    public String save() throws HeuristicMixedException, NotSupportedException, SystemException, NamingException, HeuristicRollbackException, RollbackException {
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