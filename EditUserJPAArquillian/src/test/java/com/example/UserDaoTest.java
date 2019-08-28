package com.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

@RunWith(Arquillian.class)
public class UserDaoTest {
    @Inject
    private UserDao dao;


    @Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(UserDao.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(archive.toString(true));

        return archive;
    }

    @Test
    public void findAll() {
        List<User> all = dao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void save() {
        User user = new User();
        user.setFirstName("Bram");
        user.setLastName("Janssens");

        dao.save(user);

        long janssens = dao.findAll().stream()
                .filter(u -> u.getLastName().equals("Janssens"))
                .count();

        Assert.assertTrue(janssens >= 1);

        dao.delete(user);

        long janssens2 = dao.findAll().stream()
                .filter(u -> u.getLastName().equals("Janssens"))
                .count();

        Assert.assertTrue(janssens - janssens2 == 1);
    }
}
