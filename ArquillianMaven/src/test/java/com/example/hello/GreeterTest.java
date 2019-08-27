package com.example.hello;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

// to make this run:
// - select a maven profile
// - complete the corresponding arquillian.xml
// - in IDEA: click the play button and make a run configuration with an empty manual arquillian container (since classpath is taken from pom)
// - in maven: just run mvn test
@RunWith(Arquillian.class)
public class GreeterTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "mooienaam.jar")
                .addClass(Greeter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml"); // we need an empty beans.xml file to activate CDI (EJB is automatically activated)
        System.out.println(jar.toString(true));
        return jar;
    }

    @Inject Greeter greeter;

    @Test
    public void greet() {
        String name = "Arquillian";
        Assert.assertEquals("Hello, Arquillian!", greeter.createGreeting(name));
        greeter.greet(System.out, name);
    }

    @Test
    public void greet2() {
        String name = "Arquillian2";
        Assert.assertEquals("Hello, Arquillian2!", greeter.createGreeting(name));
        greeter.greet(System.out, name);
    }

    @Test
    public void greet3() {
        String name = "Arquillian3";
        Assert.assertEquals("Hello, Arquillian3!", greeter.createGreeting(name));
        greeter.greet(System.out, name);
    }
}