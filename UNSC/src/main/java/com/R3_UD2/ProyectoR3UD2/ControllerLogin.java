package com.R3_UD2.ProyectoR3UD2;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerLogin {


    static String usuario = "Fernando";
    static String pass = "1234";
    @GetMapping("/")
    public String paginaPrincipal(HttpSession sesion){
        if(sesion.getAttribute("nombre")!= usuario && sesion.getAttribute("contraseña")!=pass){
             return "login";
        }
        System.out.println("El nombre es:"+sesion.getAttribute("nombre"));
        return "pagina1";
    }

    @PostMapping("/login")
    public String paginaCrendecial(HttpSession sesion, @RequestParam(required = false) String nombre,
                                   @RequestParam(required = false) String contraseña) {

        sesion.setAttribute("nombre",nombre);
        sesion.setAttribute("contraseña",contraseña);
        System.out.printf((String) sesion.getAttribute("nombre"));
        System.out.printf((String) sesion.getAttribute("contraseña"));
        return (String)sesion.getAttribute("nombre");
    }
}
