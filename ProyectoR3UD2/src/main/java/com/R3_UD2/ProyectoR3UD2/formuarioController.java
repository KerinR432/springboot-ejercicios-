package com.R3_UD2.ProyectoR3UD2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class formuarioController {

    @GetMapping("/")
    public String creaTuPersonaje(Historia historia) {
        return "personaje";
    }
}

