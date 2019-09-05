package com.example.cdi;

import org.slf4j.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class PersonListener {
    @Inject Logger log;

    public void onHi(@Observes Person p){
        log.info(p.name);
    }
}
