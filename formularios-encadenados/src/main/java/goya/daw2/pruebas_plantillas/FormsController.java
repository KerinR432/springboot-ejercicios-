package goya.daw2.pruebas_plantillas;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class FormsController {

	static final String[] SIGNOS = {"", "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio",
			"Sagitario", "Capricornio", "Acuario", "Piscis"};
	static final String[] AFICCIONES = {"Deportes", "Juerga", "Lectura", "Relaciones sociales"};

	// Método añadido para permitir la entrada inicial por GET
	@GetMapping("/")
	public String inicio(Model modelo) {
		modelo.addAttribute("numEtapa", 1);
		return "etapa1";
	}

	@PostMapping("/")
	String procesaEtapaX(HttpServletResponse response,
						 @RequestParam(name = "numEtapa") Integer numEtapa,
						 @RequestParam(name = "aficciones", required = false) String aficciones,
						 @RequestParam(name = "nombre", required = false) String nombre,
						 @RequestParam(name = "signo", required = false) String signo,
						 Model modelo) {

		if (numEtapa == null) return "redirect:/";

		// --- GESTIÓN DE COOKIES ---
		if (nombre != null && !nombre.isBlank()) {
			Cookie cNombre = new Cookie("cookieNombre", nombre);
			cNombre.setMaxAge(60 * 60);
			response.addCookie(cNombre);
		}

		if (signo != null && !signo.equals("0")) {
			Cookie cSigno = new Cookie("cookieSigno", signo);
			cSigno.setMaxAge(60 * 60);
			response.addCookie(cSigno);
		}

		if (aficciones != null && !aficciones.isBlank()) {
			Cookie cAficciones = new Cookie("cookieAficciones", aficciones);
			cAficciones.setMaxAge(60 * 60);
			response.addCookie(cAficciones);
		}

		// Lógica de validación
		String errores = "";
		if (numEtapa == 1 && (nombre == null || nombre.isBlank())) {
			errores = "Debes poner un nombre no vacío";
		} else if (numEtapa == 2 && (signo == null || signo.equals("0"))) {
			errores = "Debes seleccionar un signo";
		} else if (numEtapa == 3 && (aficciones == null || aficciones.isBlank())) {
			errores = "Debes elegir al menos una aficción";
		}

		if (!errores.isBlank()) {
			modelo.addAttribute("errores", errores);
			modelo.addAttribute("numEtapa", numEtapa);
			// Si hay error en etapa 2 o 3, necesitamos reenviar las listas
			modelo.addAttribute("signos", SIGNOS);
			modelo.addAttribute("aficciones", AFICCIONES);
			return "etapa" + numEtapa;
		}

		numEtapa++;

		if (numEtapa == 4) {
			return "redirect:/mostrar";
		}

		modelo.addAttribute("numEtapa", numEtapa);
		modelo.addAttribute("signos", SIGNOS);
		modelo.addAttribute("aficciones", AFICCIONES);

		return "etapa" + numEtapa;
	}

	@GetMapping("/mostrar")
	public String mostrar(Model modelo,
						  @CookieValue(name = "cookieNombre", defaultValue = "Desconocido") String nombre,
						  @CookieValue(name = "cookieSigno", defaultValue = "0") String signo,
						  @CookieValue(name = "cookieAficciones", defaultValue = "") String aficciones) {

		ArrayList<String> respuestas = new ArrayList<>();
		respuestas.add(nombre);

		int indexSigno = 0;
		try {
			indexSigno = Integer.parseInt(signo);
		} catch (NumberFormatException e) { }

		respuestas.add(SIGNOS[indexSigno]);
		respuestas.add(aficciones);

		modelo.addAttribute("respuestas", respuestas);

		return "etapa4";
	}
}