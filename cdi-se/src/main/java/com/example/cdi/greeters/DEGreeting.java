package com.example.cdi.greeters;

import com.example.cdi.greeters.qualifiers.DE;

@DE
public class DEGreeting implements IGreeting {
    @Override public String greet(String name) {
        return "Gutentag " + name;
    }
}