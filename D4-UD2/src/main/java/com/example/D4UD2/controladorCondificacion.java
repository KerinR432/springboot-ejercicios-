package com.example.D4UD2;

import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

@Controller
public class controladorCondificacion {
    @GetMapping("/")

    public String from1(Persona persona){
        return "formulario1";
    }

    @PostMapping("/")

    public String resulado(@Valid Persona persona){
        String nombreEncode = URLEncoder.encode(persona.getAnimalFav(), Charset.defaultCharset());
        return "resultado";
    }

    @Bean
    ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("mensaje");
        return messageSource;
    }
}
