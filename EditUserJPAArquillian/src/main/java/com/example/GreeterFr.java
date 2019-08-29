package com.example;

import javax.inject.Named;

// @Dependent // not needed when empty beans.xml present in WEB-INF
@FR
public class GreeterFr implements IGreeter {
    public String greet(String name) {
        return name != null ? "Bonjour " + name : "Bonjour étranger";
    }
}
