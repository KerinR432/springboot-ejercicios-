package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
@Setter
@Getter
@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Alumno() {

    }
    public Alumno(Long id, String nombre, String apellido, Curso curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Alumno{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", curso=").append(curso);
        sb.append('}');
        return sb.toString();
    }
}
