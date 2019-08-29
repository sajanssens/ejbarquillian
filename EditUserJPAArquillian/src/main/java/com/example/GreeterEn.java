package com.example;

import javax.inject.Named;

// @Dependent // not needed when empty beans.xml present in WEB-INF
@EN
public class GreeterEn implements IGreeter {
    public String greet(String name) {
        return name != null ? "Hello " + name : "Hello stranger";
    }
}
