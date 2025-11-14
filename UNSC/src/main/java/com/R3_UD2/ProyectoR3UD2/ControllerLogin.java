package com.R3_UD2.ProyectoR3UD2;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerLogin {


    //* creamos variables globales
    static String usuario = "Fernando";
    static String pass = "1234";


    //*Muestra la pagina principal, comprueba si existe las credencias
    @GetMapping("/")
    public String paginaPrincipal(HttpSession sesion) {
        if (!usuario.equals(sesion.getAttribute("nombre")) || !pass.equals(sesion.getAttribute("contraseña"))) {
            return "redirect:/login";
        }
        return "redirect:/credenciales";
    }

    @GetMapping("/login")
    public String paginaLogiarse(HttpSession sesion, @RequestParam(required = false) String nombre,
                                 @RequestParam(required = false) String contraseña,Model modelo) {
        if (usuario.equals(nombre) && pass.equals(contraseña)) {
            sesion.setAttribute("nombre", nombre);
            sesion.setAttribute("contraseña", contraseña);
            return "redirect:/credenciales";
        }
        modelo.addAttribute("Error, Usuario y/0 contraseña incorrecta");
        return "login";
    }

    @GetMapping("/credenciales")
    public String credenciales(HttpSession sesion, Model modelo,
                               @RequestParam(value = "bton", required = false) String valorBoton,
                               @RequestParam(value = "bton2", required = false) String valorBoton2) {
        if (!usuario.equals(sesion.getAttribute("nombre")) || !pass.equals(sesion.getAttribute("contraseña"))) {
            return "redirect:/login";
        }
        modelo.addAttribute("nombreUsuario", sesion.getAttribute("nombre"));
        if ("misiones".equals(valorBoton)) {
            System.out.println("estoy dentro");
            return "redirect:/pagina2";
        }
        if("Cerrar Sesión".equals(valorBoton2)){
            return "redirect:/cerrarSesion";
        }
        return "credenciales";
    }

    @GetMapping("/pagina2")
    public String misiones(HttpSession sesion, @RequestParam(value = "bton1", required = false) String valorBton1,
                           @RequestParam(value = "bton2",required = false) String valorBton2) {
        if("Credenciales".equals(valorBton1)){
            return "redirect:/credenciales";
        }
        if("Cerrar Sesión".equals(valorBton2)){
            return "redirect:/cerrarSesion";
        }
        return "pagina2";
    }

    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/login";
    }
}
