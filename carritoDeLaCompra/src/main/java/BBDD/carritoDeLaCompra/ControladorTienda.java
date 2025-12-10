package BBDD.carritoDeLaCompra;

import BBDD.carritoDeLaCompra.entities.ProductoAlmacen;
import BBDD.carritoDeLaCompra.services.ServicioAlmacen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ControladorTienda {

    // Creamos un metodo ServiciosAlmacen donde este servicies, va ha realizar todo el trabajo
    //    de logica
    ServicioAlmacen servicioAlmacen;
    public ControladorTienda(ServicioAlmacen servicioAlmacen) {
        this.servicioAlmacen = servicioAlmacen;

    }

    @GetMapping("/")
    public String muestraFormularioTienda(Model modelo){
        modelo.addAttribute("finalCompra",false);
        modelo.addAttribute("almacen", servicioAlmacen.getAll());
        return "carrito";
    }

    @PostMapping("/")
    public String procesaFormmularioTienda(Model modelo,
                                           @RequestParam Map<String,String> campoForm)
    {
        campoForm.remove("comprar");
        servicioAlmacen.restaStock(campoForm);
        return "carrito";
    }
}
