package goya.daw2.pruebas_plantillas;

import java.util.ArrayList;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FormsController {

	static final String[] SIGNOS = { "", "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio",
			"Sagitario", "Capricornio", "Acuario", "Piscis" };
	static final String[] AFICCIONES = { "Deportes", "Juerga", "Lectura", "Relaciones sociales" };

	@PostMapping("/")
	String procesaEtapaX(@RequestParam(name = "aficciones", required = false) String aficciones,
                         @RequestParam(name = "nombre", required = false) String nombre,
                         @RequestParam(name = "signo", required = false) String signo, Model modelo, HttpSession sesion) {


        modelo.addAttribute("signos", SIGNOS);
        modelo.addAttribute("aficciones", AFICCIONES);

       Integer numEtapa = (Integer) sesion.getAttribute("numEtapa");
        System.out.printf("Etapa"+numEtapa);
		if (numEtapa == null) {
            sesion.setAttribute("numEtapa",1);
            return "etapa1";
        }
		if (nombre != null) {
            sesion.setAttribute("nombre",nombre);
		}

		if (signo != null) {
			sesion.setAttribute("signo", signo);
		}

		String errores = "";

		if (numEtapa == 1 && (nombre == null || nombre.isBlank())) {
			errores = "Debes poner un nombre no vacío";
		} else if (numEtapa == 1 && (nombre.length() < 3 || nombre.length() > 10)) {
			errores = "La longitud del nombre debe estar entre 3 y 10";
		}

		if (numEtapa == 2 && (signo == null || signo.equals("0"))) {
			errores = "Debes seleccionar un signo";
		}

		if (numEtapa == 3 && (aficciones == null || aficciones.isBlank())) {
			errores = "Debes elegir al menos una aficción, no seas soso/a";
		}

		if (!errores.isBlank()) {
			modelo.addAttribute("errores", errores);
            modelo.addAttribute("numEtapa",numEtapa);
			return "etapa" + numEtapa;
		}

		numEtapa++;

		sesion.setAttribute("numEtapa", numEtapa);
        modelo.addAttribute("numEtapa",numEtapa);

		if (numEtapa == 4) {
			ArrayList<String> respuestas = new ArrayList<String>();
			nombre = (String)sesion.getAttribute("nombre");
            signo = (String)sesion.getAttribute("signo");
            respuestas.add(nombre);
            respuestas.add(SIGNOS[Integer.parseInt(signo)]);
            respuestas.add(aficciones);
            aficciones = (String)sesion.getAttribute("aficiones");
			modelo.addAttribute("respuestas", respuestas);
		}

		return "etapa" + numEtapa;
	}

	@GetMapping("/")
	String getEtapa0(HttpSession session, Model modelo) {
		session.setAttribute("etapa",1);
        modelo.addAttribute("numEtapa",1);
        return "etapa1";
	}

}
