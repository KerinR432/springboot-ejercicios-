package tienda.com.grandle;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorTienda {
    static RepositorioStock repo = new RepositorioStock();

    @GetMapping("/")
    public String bienvenido(){
        return"BienvenidoTienda";
    }

    @PostMapping("/tienda")
    public String entrar(@RequestParam String nombre, HttpSession sesion){
        sesion.setAttribute("nombre",nombre);
        return "redirect/productos";
    }

}
