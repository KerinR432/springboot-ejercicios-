package com.R3_UD2.ProyectoR3UD2;

@Entity
public class Puesto {
    @Id
            Long id;
    String nombre;
    int puntos;
    Categoria categoria;

    public Puesto() {
    }

    public Puesto(Long id, String nombre, int puntos, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}


