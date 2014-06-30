package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    final static Logger log = LoggerFactory.getLogger(HelloWorld.class);

    public static final String HELLO_WORLD = "Hello World!";

    public static void main(String[] args) {
        log.info("Hello World!");
    }

    public String greet() {
        return HELLO_WORLD;
    }
}
