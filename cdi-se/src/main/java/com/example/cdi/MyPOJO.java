package com.example.cdi;

import com.example.cdi.greeters.IGreeting;
import com.example.cdi.greeters.qualifiers.NL;
import org.slf4j.Logger;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

public class MyPOJO {

    private Logger log;

    @Inject @NL IGreeting greeters;

    @Inject @Any Event<Person> personEvent;

    @Inject
    public MyPOJO(Logger log) {
        this.log = log;
    }

    public String hi() {
        log.info("Hi was called...");
        personEvent.fire(new Person("Piet"));
        return "HI";
    }

}
