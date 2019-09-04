package com.example.cdi;

import com.example.cdi.greeters.IGreeting;
import com.example.cdi.greeters.qualifiers.NL;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Provider;

public class MyPOJO {

    private Logger log;

    @Inject @NL IGreeting greeters;

    @Inject
    public MyPOJO(Logger log) {
        this.log = log;
        IGreeting iGreeter = greeters/*.get()*/;
    }

    public String hi() {
        log.info("Hi was called...");
        return "HI";
    }

}
