package com.example.GrasaCorporalObejeto;

import jakarta.validation.constraints.*;

public class Persona {
    @Null
    @Size(min = 2, max = 30)
    @NotBlank
    private String nombre;
    @NotNull
    @Min(18)
    private Integer edad;
    private String grasaCorporal;
    @Pattern(regexp = "[HMX]")
    private String genero;

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



    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", grasaCorporal='" + grasaCorporal + '\'' + '}';
    }
}
