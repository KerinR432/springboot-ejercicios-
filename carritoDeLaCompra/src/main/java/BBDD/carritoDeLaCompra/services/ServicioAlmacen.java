package BBDD.carritoDeLaCompra.services;

import BBDD.carritoDeLaCompra.entities.ProductoAlmacen;
import BBDD.carritoDeLaCompra.repositories.RepositorioProductoAlmacen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ServicioAlmacen {
    private RepositorioProductoAlmacen repositorioProductoAlmacen;

    public ServicioAlmacen(RepositorioProductoAlmacen repositorioProductoAlmacen) {
        this.repositorioProductoAlmacen = repositorioProductoAlmacen;
        if(repositorioProductoAlmacen.count() ==0) {
            repositorioProductoAlmacen.save(new ProductoAlmacen(100,3.5,"Plátanos"));
            repositorioProductoAlmacen.save(new ProductoAlmacen(100,5.4,"Pepinos"));
            repositorioProductoAlmacen.save(new ProductoAlmacen(100,2.5,"Manzanas"));
        }
    }

    public List<ProductoAlmacen> getAll(){
        return (List<ProductoAlmacen>) repositorioProductoAlmacen.findAll();

    }
    public void restaStock(Map<String,String> productos) {
        for (String producto : productos.keySet()) {
            ProductoAlmacen productoAlmacen = repositorioProductoAlmacen.findById(producto).orElse(null);
            if (productoAlmacen != null) {
            productoAlmacen.setStock(productoAlmacen.getStock() - Integer.parseInt(productos.get(producto)));
            repositorioProductoAlmacen.save(productoAlmacen);
            }
            else{
                System.err.println("No existe el producto con el id: " + producto);
            }
        }
    }
}
