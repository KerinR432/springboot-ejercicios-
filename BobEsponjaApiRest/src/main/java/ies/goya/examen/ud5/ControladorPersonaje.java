package ies.goya.examen.ud5;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personaje")
public class ControladorPersonaje {

	private PersonajeServicio servicePersonaje;
	
	public ControladorPersonaje(PersonajeServicio personajeServicio) {
		this.servicePersonaje = personajeServicio;
	}
	
	@GetMapping
	public ResponseEntity<?> mostrarTodo() {
		List<Personaje> mostrarPersonaje = servicePersonaje.mostrarTodosLosPersonajes();
		if(mostrarPersonaje.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(mostrarPersonaje);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable(name="id") Long id) {
		Personaje motrarPersonajeID = servicePersonaje.mostrarPersonajePorID(id);
		if (motrarPersonajeID== null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(motrarPersonajeID);
	}
	
	// Por eso para actualizar me quedo con el metodo normal
	@PostMapping
	public Personaje crearPersonaje(@RequestBody Personaje personaje) {
		return servicePersonaje.crearPersonaje(personaje);
	}
	
	
	// Aqui abajo era como tenia intuio que se debia de hacer el ResponseEntity, Pero tampoco sabia como
	// asi que lo mas cerca ha sido esto.
	/**
	public ResponseEntity<?> crearPersonaje(@RequestBody Personaje personaje,HttpStatus status) {
		Personaje creado = servicePersonaje.crearPersonaje(personaje);
		return new ResponseEntity(creado, status);
	}
	*/
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody Personaje personaje) {
		Personaje actualizado = servicePersonaje.actualizar(personaje);
		
		if(actualizado.equals(null)) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(actualizado);
	}
	
	// el codigo de abajo era como tenia pensado hacer el PATCH.Cosa que al final no me salio
	/**
	@PatchMapping("/{nombre}/{descripción}")
	public Personaje actualizadoPorPartes(@RequestBody Personaje personaje,
			@PathVariable(name = "nombre")String nombre,
			@PathVariable(name = "descripción")String descripción) {
		return servicePersonaje.actualzadoAMedias(nombre, descripción, personaje);
	}
	
	*/
	
	// El Delete no lo hice con ResponseEntity, no sabia hacerlo. La unica logica que encontraba era
	// de alguna manera mediante el ID o llear al get mapping para comprobar si existia ese elemento
	// Sino existe, mandamos mensaje de error. Pero si existe mandamos mensaje de exito.
	// Esto tiene un fallo y es que si metemos un objeto que no existe, si o si devovera correcto.
	@DeleteMapping("/{id}")
	public void eliminarPesonaje(@PathVariable (name = "id") Long id) {
		servicePersonaje.eliminarPorIdPersonaje(id);
	}
}
