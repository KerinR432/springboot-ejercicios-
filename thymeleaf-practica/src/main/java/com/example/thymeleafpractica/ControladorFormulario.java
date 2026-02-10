package com.example.thymeleafpractica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorFormulario {
    @GetMapping("/formulario")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("personajeSimple",new PersonajeSimple());
        return "formulario";
    }

    @PostMapping("/resultados")
    public String procesarFormulario(@ModelAttribute PersonajeSimple persona,Model modelo){
        modelo.addAttribute("persona",persona);
        return "resultado";
    }
}
