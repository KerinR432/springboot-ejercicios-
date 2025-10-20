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
        int valor = persona.getGenero() == "H" ? 1 : 2;
        double grasas = (1.20 * persona.getIMC()) + (0.23 * persona.getEdad()) - (10.8 * valor) - 5.4;
        System.out.println(1.20* persona.getIMC()+(0.23* persona.getE   dad())-(10.8*valor));
        persona.setGrasaCorporal(String.format("%.2f", grasas));
        return "resultado";
    }
}
