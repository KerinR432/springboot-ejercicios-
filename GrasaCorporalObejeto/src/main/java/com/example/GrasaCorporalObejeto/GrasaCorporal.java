package com.example.GrasaCorporalObejeto;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GrasaCorporal {
    @GetMapping("/")
    public String verFormulario(Persona persona) {
        return "formulario";
    }

    @PostMapping("/")
    public String comprobarInfoPersona(@Valid Persona persona, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formulario";
        }
        return "resultado";
    }
}
