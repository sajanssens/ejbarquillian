package com.example.cdi.greeters;

import com.example.cdi.greeters.qualifiers.EN;

@EN
public class ENGreeting implements IGreeting {
    @Override public String greet(String name) { return "Hello " + name; }
}