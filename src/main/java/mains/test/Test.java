package mains.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Test {

    @GetMapping("/test")
    public String addDate() {
        System.out.println("hello world");
        return "hello world";
    }
}
