package com.example.hello;

import javax.ejb.Stateless;
import java.io.PrintStream;

@Stateless
public class Greeter {
    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}