package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class controladorWebCRUD {

    private final RepositorioAlumno repositorioAlumno;

    public controladorWebCRUD(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }


    @GetMapping("/alumno")
    public String formAlumno(Model modelo) {
        List<String> cursos = new ArrayList<>();
        cursos.add(" ");
        cursos.addAll(Stream.of(Curso.values()).map(a -> a.toString()).toList());
        modelo.addAttribute(repositorioAlumno.findAll());
        modelo.addAttribute("cursos", Curso.values());

        return "alumno";
    }

    @PostMapping("/alumno")
    public String procesaFormAlumno(Alumno alumno, Model modelo, @RequestParam(name = "borrar", required = false) String borrar,
                                    @RequestParam(name = "modificar", required = false) String modificar,
                                    @RequestParam(name = "crear", required = false) String crear) {
        modelo.addAttribute("cursos", Curso.values());
        modelo.addAttribute("alumnos", repositorioAlumno.findAll());
        if (borrar != null && alumno.getId() != null) {
            repositorioAlumno.deleteById(alumno.getId());
        }

        if (crear != null) {
            repositorioAlumno.save(alumno);
        }
        return "alumno";
    }
}
