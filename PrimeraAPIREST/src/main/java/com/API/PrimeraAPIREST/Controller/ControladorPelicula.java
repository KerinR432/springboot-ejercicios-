package com.API.PrimeraAPIREST.Controller;

import com.API.PrimeraAPIREST.Entities.Pelicula;
import com.API.PrimeraAPIREST.Services.ServicioPelicula;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<List<Pelicula>> listarTodo() {
        List<Pelicula> peliculas = servicioPelicula.dameTodo();
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> listarUnaPeliculaPorID(@PathVariable(name="id") long id) {
        Pelicula peliculaMostrarId = servicioPelicula.dameUnaPeliculaPorID(id).orElse(null);
        return ResponseEntity.ok(peliculaMostrarId);
    }

    @PostMapping()
    public ResponseEntity<?> crearUnaPelicula(@RequestBody Pelicula pelicula, BindingResult result) {
        Pelicula peliculaGuarda = servicioPelicula.guardar(pelicula);
        if (peliculaGuarda == null) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(peliculaGuarda);
    }

    @DeleteMapping("/{id}")
    public void borrarPelicula(@PathVariable(name="id") Long id) {
        Optional<Pelicula> peliculaOptional = servicioPelicula.dameUnaPeliculaPorID(id);
        if(peliculaOptional.isPresent()){
            servicioPelicula.borrar(peliculaOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarDatosPelicula(@PathVariable(name="id") long id, @RequestBody Pelicula pelicula) {
        Pelicula peliculaActualizada = servicioPelicula.actualizarPelicula(id, pelicula);
        return ResponseEntity.ok(peliculaActualizada);
    }
}
