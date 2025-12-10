package Gerenciamento.NilvanApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class NilvanAppController {

    @GetMapping("/home")
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/")
    public String root() {
        return "forward:/index.html";
    }
}