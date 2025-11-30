package com.cookies.login;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerCookies {

    // Muestra el formulario para ingresar el nombre de usuario
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // nombre de la vista HTML (login.html)
    }

    // Procesa el formulario y crea la cookie
    @PostMapping("/login")
    public String procesarLogin(@RequestParam String usuario, HttpServletResponse response) {
        if (usuario == null || usuario.trim().isEmpty()) {
            return "login"; // si no hay usuario, se muestra el formulario otra vez
        }
        Cookie cookie = new Cookie("usuario", usuario);
        cookie.setMaxAge(3600); // 1 hora
        cookie.setPath("/"); // cookie disponible en toda la app
        response.addCookie(cookie);
        return "redirect:/perfil"; // redirige a perfil tras login
    }

    // Muestra la vista del perfil
    @GetMapping("/perfil")
    public String perfil(@CookieValue(value = "usuario", defaultValue = "") String usuario,
                         Model model) {
        if (usuario.isEmpty()) {
            return "redirect:/login"; // si no hay cookie, redirige a login
        }

        model.addAttribute("usuario",usuario);
        return "perfil"; // nombre de la vista HTML (perfil.html)
    }

    // Ruta raíz que redirige según si hay usuario logueado o no
    @GetMapping("/")
    public String inicio(@CookieValue(value = "usuario", defaultValue = "") String usuario) {
        if (usuario.isEmpty()) {
            return "redirect:/login";
        }
        return "redirect:/perfil";
    }
}
