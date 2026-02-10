package com.correcion.Corrrecion.de.Examen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCarrito {
	final int MAX_PRODUCTOS = 3;
	final String[] PRODUCTOS = { "Fresas" , "Plátanos", "Limones" };

	
	@GetMapping("/")
	public String mostrarProductos(Model modelo) {
		System.out.println("SOY EL GET");
		modelo.addAttribute("productos",PRODUCTOS);
		
		return "carrito";
	}
	
	@PostMapping("/Mostrar")	
	public String mostrarCompra(
			@RequestParam (name ="cantidad",required = false) Integer cantidad,
			Model modelo) {
		
		System.out.println(cantidad);
		modelo.addAttribute("cantidadProducto",cantidad);
		
		System.out.println("SOY EL POST");
		
		return "mostrar";
		
	}
	
}
