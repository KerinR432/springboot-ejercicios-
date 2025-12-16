package com.R3_UD2.ProyectoR3UD2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Historia {

    private List<String> heroe = new ArrayList<>();

    private String objetos;

    private Integer estado = 1;

    private Integer puntuacion = 0;
    private String fechas = "";

    @NotBlank
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<String> getHeroe() {
        return heroe;
    }

    public void setHeroe(List<String> heroe) {
        this.heroe = heroe;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Historia{");
        sb.append("heroe=").append(heroe);
        sb.append(", objetos='").append(objetos).append('\'');
        sb.append(", estado=").append(estado);
        sb.append(", puntuacion=").append(puntuacion);
        sb.append(", fechas='").append(fechas).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", rol='").append(rol).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
