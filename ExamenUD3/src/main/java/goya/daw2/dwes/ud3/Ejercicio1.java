package goya.daw2.dwes.ud3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ejercicio1 {
	static final String[] USUARIOS = { "Bob", "Calamardo", "Arenita" };

	@GetMapping("/Ejercicio1")
	public String listaChats(Model modelo) {
		modelo.addAttribute("usuarios", USUARIOS);
		return "chats";
	}

	@GetMapping("/chat")
	public String chat(@RequestParam(name = "usuario") String usuario, Model modelo) {
		LocalDateTime hora = LocalDateTime.now();
		modelo.addAttribute("hora",hora.format(DateTimeFormatter.ofPattern("dd-MM-uu HH:mm")));
		modelo.addAttribute("usuario", usuario);
		
		return "chat";
	}

}
