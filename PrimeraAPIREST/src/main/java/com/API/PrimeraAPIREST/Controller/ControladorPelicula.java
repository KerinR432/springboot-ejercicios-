package com.API.PrimeraAPIREST.Controller;

import com.API.PrimeraAPIREST.Entities.Pelicula;
import com.API.PrimeraAPIREST.Services.ServicioPelicula;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Peliculas")
public class ControladorPelicula {
    private ServicioPelicula servicioPelicula;

    public ControladorPelicula(ServicioPelicula servicioPelicula) {
        this.servicioPelicula = servicioPelicula;
    }

    @GetMapping()
    public List<Pelicula> listarTodo() {
        return servicioPelicula.dameTodo();
    }

    @GetMapping("/{id}")
    public Pelicula listarUnaPeliculaPorID(@PathVariable(name="id") long id) {
        return servicioPelicula.dameUnaPeliculaPorID(id).orElse(null);
    }

    @PostMapping()
    public Pelicula crearUnaPelicula(@RequestBody Pelicula pelicula) {
        return servicioPelicula.guardar(pelicula);
    }

    @DeleteMapping("/{id}")
    public void borrarPelicula(@PathVariable(name="id") Long id) {
        Optional<Pelicula> peliculaOptional = servicioPelicula.dameUnaPeliculaPorID(id);
        if(peliculaOptional.isPresent()){
            servicioPelicula.borrar(peliculaOptional.get());
        }
    }

    @PutMapping("/{id}")
    public Pelicula actualizarDatosPelicula(@PathVariable(name="id") long id, @RequestBody Pelicula pelicula) {
        return servicioPelicula.actualizarPelicula(id, pelicula);
    }
}
