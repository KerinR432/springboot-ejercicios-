package com.example.GrasaCorporalObejeto;

import jakarta.validation.constraints.*;

public class Persona {
    @NotNull
    @Size(min = 2, max = 30)
    private String nombre;
    @NotNull
    private Integer edad;

    private String grasaCorporal;

    private String genero;

    private double IMC;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGrasaCorporal() {
        return grasaCorporal;
    }

    public void setGrasaCorporal(String grasaCorporal) {
        this.grasaCorporal = grasaCorporal;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", grasaCorporal='" + grasaCorporal + '\'' + '}';
    }
}
