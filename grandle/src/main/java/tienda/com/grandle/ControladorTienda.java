package tienda.com.grandle;
/*
 * productosYprecio
 * total
 * porductos
 * */

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorTienda {
    static String usuario = "Moha";
    private static RepositorioStockEnTxt repositorio = new RepositorioStockEnTxt();
    static final String[] PRODUCTOS = {"Hamburgesa Moa", "Nueggets Moa", "Fish Tacos"};
    static final double[] PRECIOS = {4.3, 5.3, 2.1};

    @GetMapping("/")
    public String mostrar(Model modelo, HttpSession sesión) {
        modelo.addAttribute("productos", PRODUCTOS);
        modelo.addAttribute("precios", PRECIOS);
        double total = 0;
        //pasa a la plantilla el carrito que hay en la sesión:
        int[] cantidadesSesion = (int[]) sesión.getAttribute("cantidades");
        if (cantidadesSesion != null) {
            String[] productosYcantidades = new String[PRODUCTOS.length];
            for (int i = 0; i < PRODUCTOS.length; i++) {
                productosYcantidades[i] = PRODUCTOS[i] + ":" + cantidadesSesion[i];
                total += cantidadesSesion[i] * PRECIOS[i];
            }
            modelo.addAttribute("productosYcantidades", productosYcantidades);
        }
        modelo.addAttribute("total", total);
        modelo.addAttribute("productosYstock", repositorio.getAll());
        return "Tienda";
    }

    @PostMapping("/")
    public String procesaCarrito(Model modelo,
                                 @RequestParam(name = "cantidades") int[] cantidades,
                                 @RequestParam(name = "compra", required = false) String comprar,
                                 HttpSession sesion) {
        modelo.addAttribute("productos", PRODUCTOS);
        modelo.addAttribute("precios", PRECIOS);
        modelo.addAttribute("productosYstock", repositorio.getAll());
        int[] cantidadSesison = (int[]) sesion.getAttribute("cantidades");
        double total = 0;
        //consolido lo que hay en sesión (carrito) con lo que llega
        //en formulario previo:
        if (cantidadSesison != null) {
            for (int i = 0; i < PRODUCTOS.length; i++) {
                cantidadSesison[i] += cantidades[i];
            }
        } else {
            cantidadSesison = cantidades;
        }
        sesion.setAttribute("cantidades", cantidadSesison);

        //sesion.setAttribute("cantidades",cantidades);
        String[] productosYcantidades = new String[PRODUCTOS.length];

        for (int i = 0; i < PRODUCTOS.length; i++) {
            productosYcantidades[i] = PRODUCTOS[i] + ":" + cantidadSesison[i];
            productosYcantidades[i] = String.format("%s : %5d * %.2f = %.2f", PRODUCTOS[i],
                    cantidadSesison[i], PRECIOS[i], cantidadSesison[i] * PRECIOS[i]);
            total +=  cantidadSesison[i] * PRECIOS[i];
        }
        modelo.addAttribute("productosYcantidades", productosYcantidades);
        if (comprar != null) {
            for (int i = 0; i < cantidadSesison.length; i++) {
                Integer stockEnDisco = repositorio.getOne(PRODUCTOS[i]);
                if (stockEnDisco == null) stockEnDisco = 0;
                if(cantidadSesison[i]> stockEnDisco){
                    cantidadSesison[i] = stockEnDisco;
                }
                repositorio.modify(PRODUCTOS[i], stockEnDisco - cantidadSesison[i]);
                cantidadSesison[i] = 0;
            }
            sesion.setAttribute("cantidades", cantidadSesison);
            modelo.addAttribute("finalCompra", true);
        }
        //* de las formas
        //modelo.addAttribute("total", String.format("%.2f",total));
        total = Math.round(total);
        modelo.addAttribute("total",total);
        return "Tienda";
    }


   /* @GetMapping("/")
    public String bienvenido(HttpSession sesision){
        if(!usuario.equals(sesision.getAttribute("nombre"))){
            return "redirect:/login";
        }
        return "redirect:/tienda";
    }

    @PostMapping("/tienda")
    public String entrar(@RequestParam String nombre, HttpSession sesion){
        sesion.setAttribute("nombre",nombre);
        return "Tienda";
    }


    @GetMapping("/login")
    public String paginaLogiarse(HttpSession sesion, @RequestParam(required = false) String nombre, Model modelo) {
        if (usuario.equals(nombre)) {
            sesion.setAttribute("nombre", nombre);
            return "redirect:/tienda";
        }
        modelo.addAttribute("Error, Usuario y/0 contraseña incorrecta");
        return "BienvenidoTienda";
    }
*/
}
