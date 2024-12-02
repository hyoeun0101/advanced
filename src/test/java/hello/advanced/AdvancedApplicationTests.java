package hello.advanced;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootTest
class AdvancedApplicationTests {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {


    }

}
