package BBDD.carritoDeLaCompra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
public class carritoControlador {

    private RepositorioTienda repositoriotienda;

    public ControladorCarrito

    @Bean
    public CommandLineRunner demo(RepositorioTienda repositorio) {
        return (String[] args) -> {
            // save a few customers
            repositorio.save(new Producto("Manazana",12.4,10));
            repositorio.save(new Producto("Peras",5.7,5));
            repositorio.save(new Producto("Mandarinas",5.6,12));
        };
    }
    @GetMapping("/Tienda")
    public String tiendaGet(Model model) {

        model.addAttribute("precioProv", repositoriotienda.findById(1).get().getPrecio());
        model.addAttribute("carrito", repositoriotienda.findAll());
        model.addAttribute("cantidades", repositoriotienda.findById(1).get().getPrecio());
        return "Tienda";
    }
}
