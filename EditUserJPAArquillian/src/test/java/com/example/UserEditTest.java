package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
public class UserEditTest {
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(UserEdit.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject private UserEdit userEdit;

    @Test
    public void greeter() {
        String greeting = userEdit.getGreeting();
        assertThat(greeting, is(notNullValue()));
        assertThat(greeting, containsString("Bram"));
    }

    @Test
    public void save() {
        User user = new User();
        user.setFirstName("Bram");
        user.setLastName("Janssens");

        UserDao dao = userEdit.getUserDAO();

        long janssens = dao.findAll().stream()
                .filter(u -> u.getLastName().equals("Janssens"))
                .count();

        userEdit.setUser(user);
        userEdit.save();

        long janssens2 = dao.findAll().stream()
                .filter(u -> u.getLastName().equals("Janssens"))
                .count();

        assertThat(janssens2 - janssens, is(1L));
    }
}
