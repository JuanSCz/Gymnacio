package com.gymnacioWEB.gymnacioWEB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClienteController {

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

}
