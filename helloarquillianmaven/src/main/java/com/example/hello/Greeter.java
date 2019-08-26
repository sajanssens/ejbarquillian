package com.example.hello;

import javax.enterprise.context.Dependent;
import java.io.PrintStream;

@Dependent
public class Greeter {
    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}