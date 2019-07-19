package ufma.mestrado.portaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/index")
    public String home() {
        return "/index";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}
