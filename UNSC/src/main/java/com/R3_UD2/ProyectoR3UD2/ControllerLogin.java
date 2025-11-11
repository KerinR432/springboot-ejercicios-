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
        //* sino existen, devuelve pagina de iniciar sesión, si existen. Mostrar credenciales
        if (!usuario.equals(sesion.getAttribute("nombre")) || !pass.equals(sesion.getAttribute("contraseña"))) {
            return "redirect:/login";
        }
        System.out.println("El nombre es:" + sesion.getAttribute("nombre"));
        return "redirect:/credenciales";
    }

    //* comprovamos si el nombre y la contraseña es igual a la que esta almacenanda ne la base de Datos
    @GetMapping("/login")
    public String paginaLogiarse(HttpSession sesion, @RequestParam(required = false) String nombre,
                                 @RequestParam(required = false) String contraseña) {
        //*Si es si, devolvemos crendeciales, sino devolvemos la pagina iniciar sesión hasta que sea correcto
        if (usuario.equals(nombre) && pass.equals(contraseña)) {
            sesion.setAttribute("nombre", nombre);
            sesion.setAttribute("contraseña", contraseña);
            return "redirect:/credenciales";
        }
        return "login";
    }


    //*Esto es mostrar la pagina 1 o crendeciales como la he nombrado yo, volvemos a tener una condoción
    //*si por algun casual entramos en pagina 1. si la crendecial no son correctas o se recuerda, vuelve pagina login
    @GetMapping("/credenciales")
    public String credenciales(HttpSession sesion, Model modelo,
                               @RequestParam(value = "bton", required = false) String valorBoton,
                               @RequestParam(value = "bton2", required = false) String valorBoton2) {
        if (!usuario.equals(sesion.getAttribute("nombre")) || !pass.equals(sesion.getAttribute("contraseña"))) {
            return "redirect:/login";
        }
        //*Tambien tengo 2 botones, cerrar sesión y ir a pagina 2 o misiones
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

    //* Esto muestra pagina 2 o misiones como lo tengo yo, igual tiene 2 botones como ayer
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

    //* cerrar sesión es invalidar la sesion y redirigir directamente a la pagina de logeo
    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/login";
    }
}
