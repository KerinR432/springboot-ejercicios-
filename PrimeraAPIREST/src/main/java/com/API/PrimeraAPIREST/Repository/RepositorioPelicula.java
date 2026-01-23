package com.API.PrimeraAPIREST.Repository;

import com.API.PrimeraAPIREST.Entities.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPelicula extends CrudRepository<Pelicula, Long> {
    boolean existsByNombre(String nombre);
    boolean existsByDirector(String director);

}
