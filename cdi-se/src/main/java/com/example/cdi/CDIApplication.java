package com.example.cdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class CDIApplication {

    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();

        // Container will be weld since it is on the classpath; when omitted, no CDI-container is found.
        // Discovery and/or presence of beans.xml are interrelated.
        try (SeContainer container = initializer/*.disableDiscovery().addPackages(CDIApplication.class)*/.initialize()) {
            MyService myService = container.select(MyService.class).get();
            System.out.println(myService.doeIets());
        }
    }
}