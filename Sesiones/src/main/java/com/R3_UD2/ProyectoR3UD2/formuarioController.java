package com.R3_UD2.ProyectoR3UD2;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class formuarioController {

    @GetMapping("/")
    public String creaTuPersonaje(Historia historia) {
        return "personaje1";
    }

    @PostMapping("/")
    public String comprobarInfoPersonaje(@Valid Historia historia, BindingResult bindingResult,
                                         @RequestParam(name = "op") int op, HttpSession sesion)
    {
        Integer numEtapa = (Integer) sesion.getAttribute("op");

        sesion.setAttribute("NumEtapa",1);
        if (bindingResult.hasErrors()) {
            return "personaje";
        }
        historia.setEstado(historia.getEstado() + op);
        if(historia.getEstado()>3)
        {
            List<String>datos = new ArrayList<>();
            datos.add(historia.getNombre());
            datos.add(historia.getRol());
            datos.add(historia.getObjetos());
            historia.setHeroe(datos);
            return "resultado";
        }
        return "personaje"+historia.getEstado();
    }
}

