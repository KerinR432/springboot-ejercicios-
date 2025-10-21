package com.R3_UD2.ProyectoR3UD2;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formuarioController {

    @GetMapping("/")
    public String creaTuPersonaje(Historia historia) {
        return "personaje1";
    }

    @PostMapping("/")
    public String comprobarInfoPersonaje(@Valid Historia historia, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "personaje" + historia.getEstado();
        }
        historia.setEstado(historia.getEstado() + 1);
        if(historia.getEstado()>3)
            return "resultado";
        return "personaje"+historia.getEstado();
    }
}

