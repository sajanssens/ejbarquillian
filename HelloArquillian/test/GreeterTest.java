import com.example.hello.Greeter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

// fix build error by adding junit4 to classpath
@RunWith(Arquillian.class)
public class GreeterTest {

    // See https://www.jetbrains.com/help/idea/arquillian.html for running and configuring in IDEA

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Greeter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject Greeter greeter;

    @Test
    public void greet() throws Exception {
        String name = "Arquillian";
        Assert.assertEquals("Hello, Arquillian!", greeter.createGreeting(name));
        greeter.greet(System.out, name);
    }
}