package com.example.thymeleafpractica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorSaludos {

    @GetMapping("/saludos")
    public String saludos(@RequestParam(name = "nombre",required = false,defaultValue = "Hola  Mundo")
                              String nombre, Model modelo){
        modelo.addAttribute("nombre",nombre);
        return "saludos";
    }
}
