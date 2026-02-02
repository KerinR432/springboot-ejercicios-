package ies.goya.examen.ud5;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonajeServicio {

	private RepositoryPersonaje repoPersonaje;
	
	public PersonajeServicio (RepositoryPersonaje repositorioPersonaje) {
		this.repoPersonaje = repositorioPersonaje;
	}
	
	public List<Personaje> mostrarTodosLosPersonajes() {
		return (List<Personaje>) repoPersonaje.findAll();
	}
	
	public Personaje crearPersonaje(Personaje personaje) {
		return repoPersonaje.save(personaje);
	}
	
	public Personaje mostrarPersonajePorID(Long id) {
		return repoPersonaje.findById(id).orElse(null);
	}
	
	public void eliminarPorIdPersonaje(Long id) {
		repoPersonaje.deleteById(id);
	}
	
	public Personaje actualizar(Personaje personaje) {
		return repoPersonaje.save(personaje);
	}
	
	
	//este codigo de aqui, era mi intuisión de como deberua ser hacerse el PATCH
	/**
	public Personaje actualzadoAMedias(String nombre,String descripción,Personaje personajeActualizado) {
		
		personajeActualizado.setNombre(nombre);
		personajeActualizado.setDescripción(descripción);
		
		return repoPersonaje.save(personajeActualizado);
		
	}
	*/
	
	
	
}
