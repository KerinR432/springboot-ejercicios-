package com.R3_UD2.ProyectoR3UD2;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Historia {
    private List<String> heroe = new ArrayList();
    private String objetos;
    private int estado =1;
    @NotNull
    private String nombre;
    private String rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getObjetos() {
        return objetos;
    }

    public void setObjetos(String objetos) {
        this.objetos = objetos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<String> getHeroe() {
        return heroe;
    }

    public void setHeroe() {
            heroe.clear();
            heroe.add(nombre);
            heroe.add(rol);
            heroe.add(objetos);

    }

    @Override
    public String toString() {
        String sb = "Historia{" + "nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", objetos='" + objetos + '\'' +
                '}';
        return sb;
    }
}
