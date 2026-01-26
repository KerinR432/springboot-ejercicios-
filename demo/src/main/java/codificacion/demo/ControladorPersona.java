package codificacion.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPersona {

    @GetMapping("/")
    public String home() {
        return "API viva y coleando";
    }
}

