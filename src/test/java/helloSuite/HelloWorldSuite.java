package helloSuite;

import hello.HelloWorld;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by cganoo on 6/23/14.
 */
public class HelloWorldSuite {

    @Test
    public void checkHelloWorldResponse() {
        final HelloWorld greeter = new HelloWorld();
        assertThat(greeter, notNullValue());

        final String greeting  = greeter.greet();
        assertThat(greeting, notNullValue());
        assertThat(greeting, is("Hello World!"));
    }
}
