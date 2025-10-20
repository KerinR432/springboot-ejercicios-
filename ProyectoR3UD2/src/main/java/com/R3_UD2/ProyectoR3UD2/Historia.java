package com.R3_UD2.ProyectoR3UD2;

import jakarta.validation.constraints.NotNull;

public class Historia {

    @NotNull
    private String nombre;
    private String rol;
    private String objetos;

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

    @Override
    public String toString() {
        String sb = "Historia{" + "nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", objetos='" + objetos + '\'' +
                '}';
        return sb;
    }
}
