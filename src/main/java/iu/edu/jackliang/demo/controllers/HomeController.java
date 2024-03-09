package iu.edu.jackliang.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String Welcome(){
        return "Welcome to the guitar page!";
    }
}
