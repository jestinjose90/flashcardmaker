package edu.neiu.flashcardmaker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHomePage() {
        return "index-page";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
