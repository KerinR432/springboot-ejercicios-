package com.API.PrimeraAPIREST.Services;

import com.API.PrimeraAPIREST.Entities.Pelicula;
import com.API.PrimeraAPIREST.Repository.RepositorioPelicula;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPelicula {
    private RepositorioPelicula repositorioPelicula;

    public ServicioPelicula(RepositorioPelicula repositorio) {
        this.repositorioPelicula = repositorio;
    }


    public List<Pelicula> dameTodo() {
        return (List<Pelicula>) repositorioPelicula.findAll();
    }

    public Optional<Pelicula> dameUnaPeliculaPorID(Long id) {
        return repositorioPelicula.findById(id);
    }

    public Pelicula guardar(Pelicula pelicula) {
        return repositorioPelicula.save(pelicula);
    }

    public void borrar(Pelicula pelicula) {
         repositorioPelicula.delete(pelicula);
    }

    public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
        Pelicula peliculaParaActualizar = repositorioPelicula.findById(id).orElse(null);

        peliculaParaActualizar.setNombre(pelicula.getNombre());
        peliculaParaActualizar.setDirector(pelicula.getDirector());
        peliculaParaActualizar.setCategoria(pelicula.getCategoria());

        return repositorioPelicula.save(peliculaParaActualizar);
    }
}
