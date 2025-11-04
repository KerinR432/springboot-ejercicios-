package com.example.D4UD2;

public class Persona {
    private String nombre;
    private String animalFav;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnimalFav() {
        return animalFav;
    }

    public void setAnimalFav(String animalFav) {
        this.animalFav = animalFav;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", animalFav='").append(animalFav).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
