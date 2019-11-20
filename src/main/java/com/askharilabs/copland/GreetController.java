package com.askharilabs.copland;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GreetController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
