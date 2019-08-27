package com.example.hello.cdi;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.PrintStream;

@Dependent // must use a cdi annotation here (if one is used), or no annotation
public class GreeterCDI {

    private PhraseBuilder phraseBuilder;

    @Inject
    public GreeterCDI(PhraseBuilder phraseBuilder) {
        this.phraseBuilder = phraseBuilder;
    }

    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return phraseBuilder.buildPhrase("hello", name);
    }
}