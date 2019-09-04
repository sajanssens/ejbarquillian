package com.example.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MyService {

    @Inject
    private MyPOJO myPOJO;

    public String doeIets() {
        return myPOJO.hi();
    }

}
