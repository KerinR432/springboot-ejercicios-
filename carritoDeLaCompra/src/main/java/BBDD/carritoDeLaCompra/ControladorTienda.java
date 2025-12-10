package BBDD.carritoDeLaCompra;

import BBDD.carritoDeLaCompra.entities.ProductoAlmacen;
import BBDD.carritoDeLaCompra.services.ServicioAlmacen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
//* ------------------------ CONTROLADOR -----------------------
@Controller
public class ControladorTienda {
/**
 * El controlador, el que muestra y recibe los datos, de la paginas. Todos los datos que recibimos
 * de los usuario, los podremos procesar, mandar y luego mostrarle lo que la logica de nuestro programa queria
 * hacer
 * */

    // Creamos un metodo ServiciosAlmacen donde este servicies, va ha realizar todo el trabajo
    //    de logica
    ServicioAlmacen servicioAlmacen;
    public ControladorTienda(ServicioAlmacen servicioAlmacen) {
        this.servicioAlmacen = servicioAlmacen;

    }

    // Mapeamos el y mostramos la pagina carrito
    @GetMapping("/")
    public String muestraFormularioTienda(Model modelo){
        modelo.addAttribute("finalCompra",false);
        modelo.addAttribute("almacen", servicioAlmacen.getAll());
        return "carrito";
    }

    // Procesamos todo o que hemos recibido y se lo pasamos a servicios
    @PostMapping("/")
    public String procesaFormmularioTienda(Model modelo,
                                           @RequestParam Map<String,String> campoForm)
    {
        campoForm.remove("comprar");
        servicioAlmacen.restaStock(campoForm);
        return "carrito";
    }
}
