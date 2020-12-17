package mains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "mains.test")
@ComponentScan(basePackages = "mains.other")
@ComponentScan(basePackages = "mains.course")
@ComponentScan(basePackages = "mains.category")
@SpringBootApplication
public class AStudyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AStudyServerApplication.class, args);
    }

}
