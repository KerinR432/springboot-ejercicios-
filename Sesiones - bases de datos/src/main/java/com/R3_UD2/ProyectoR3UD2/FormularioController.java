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
public class FormularioController {

    private final PartidaRepository partidaRepository;

    public FormularioController(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @GetMapping("/")
    public String creaTuPersonaje(Historia historia, HttpSession sesion) {

        // Inicializamos la etapa solo si no existe
        if (sesion.getAttribute("numEtapa") == null) {
            sesion.setAttribute("numEtapa", 1);
        }

        // Estado inicial por si viene null
        if (historia.getEstado() == null) {
            historia.setEstado(1);
        }

        return "personaje1";
    }

    @PostMapping("/")
    public String comprobarInfoPersonaje(
            Historia historia,
            BindingResult bindingResult,
            @RequestParam(name = "op", defaultValue = "0") int op,
            HttpSession sesion) {

        // Estado defensivo
        if (historia.getEstado() == null) historia.setEstado(1);

        int estadoActual = historia.getEstado();
        int siguienteEstado = estadoActual + op;

        // VALIDACIÓN SOLO DEL PASO ACTUAL
        switch (estadoActual) {
            case 1: // nombre
                if (historia.getNombre() == null || historia.getNombre().isBlank()) {
                    bindingResult.rejectValue("nombre", "error.nombre", "Debes ingresar un nombre");
                    return "personaje1";
                }
                break;

            case 2: // rol
                if (historia.getRol() == null || historia.getRol().isBlank()) {
                    bindingResult.rejectValue("rol", "error.rol", "Debes elegir un rol");
                    return "personaje2";
                }
                break;

            case 3: // objetos
                if (historia.getObjetos() == null || historia.getObjetos().isEmpty()) {
                    bindingResult.rejectValue("objetos", "error.objetos", "Debes seleccionar al menos un objeto");
                    return "personaje3";
                }
                break;
        }

        System.out.println("Rol recibido: " + historia.getRol());

        // Avanzamos el estado
        historia.setEstado(siguienteEstado);
        sesion.setAttribute("numEtapa", siguienteEstado);

        // Resultado final
        if (siguienteEstado > 3) {
            List<String> datos = new ArrayList<>();
            datos.add(historia.getNombre());
            datos.add(historia.getRol());
            datos.add(historia.getObjetos().toString());

            historia.setHeroe(datos);

            int puntuacion = cacularPuntuacion(historia);
            PuntuacionPartida puntuacionPartida = new PuntuacionPartida(historia.getNombre(),puntuacion);
            partidaRepository.save(puntuacionPartida);
            return "resultado";
        }

        return "personaje" + siguienteEstado;
    }

    private int cacularPuntuacion(Historia historia) {
        int puntos = 0;
        if(historia.getObjetos() != null){
            puntos += historia.getObjetos().length() * 5;
            switch (historia.getRol()) {
                case "Berserk": puntos += 20; break;
                case "Tanque": puntos += 15; break;
                case "Arquero": puntos += 10; break;
                case "Rogue": puntos += 10; break;
                case "Sanador": puntos += 15; break;
                case "Necromance": puntos += 20; break;
                case "Clerigo": puntos += 15; break;
                case "Caballero": puntos += 23; break;
            }
        }
        return puntos;
    }

}
